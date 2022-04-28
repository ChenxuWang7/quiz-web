package com.example.quizapp.controller;

import com.example.quizapp.model.*;
import com.example.quizapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;

@Controller
public class QuizController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private TakeQuizService takeQuizService;

    @Autowired
    private ChoiceService choiceService;

    @Autowired
    private QuizResultService quizResultService;

    private Date date_tmp;

    @RequestMapping(value= {"/quiz/{quizId}"}, method= RequestMethod.GET)
    public ModelAndView showQuiz(@PathVariable int quizId) {
        ModelAndView model = new ModelAndView();
        Quiz quiz = quizService.findByQuizId(quizId);
        System.out.println("There is quiz " + quizId);

        model.addObject("quizId",quizId);
        model.addObject("quizName", quiz.getQuizName());
        model.addObject("quizDescription", quiz.getQuizDescription());


        List<Question> questionList = questionService.findByQuiz(quiz);

        Collections.shuffle(questionList);

        int count = 10;
        List<Question> questionsForUser = new ArrayList<>();
        for(int i = 0; i < count; i++){
            questionsForUser.add(questionList.get(i));
        }

        for(Question question : questionsForUser){
            Collections.shuffle(question.getChoices());
        }
        model.addObject("questionList", questionsForUser);

        //--------------- to save takequiz--------
        Date date = new Date();
        date_tmp = date;
//        java.text.SimpleDateFormat sdf =
//                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date startTime = (Date) sdf.format(date);


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("User Home's visitor is " + auth.getAuthorities());
        User user = userService.findUserByEmail(auth.getName());
        System.out.println(" test for user:"+ user.getLastname());

        TakeQuiz takeQuiz = new TakeQuiz(user, quiz, date);

        System.out.println(takeQuiz.toString());

        takeQuizService.save(takeQuiz);


        model.setViewName("home/quiz");

        return model;
    }


    @RequestMapping(value= {"/quiz/{quizId}/result"}, method=RequestMethod.POST)
    public ModelAndView getQuizResults(@ModelAttribute ChoiceForm choiceForm, @PathVariable int quizId ) {
        ModelAndView model = new ModelAndView();
        System.out.println(choiceForm.toString());

        //------get user, takeQuiz, quiz info.
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("User Home's visitor is " + auth.getAuthorities());
        User user = userService.findUserByEmail(auth.getName());

        model.addObject("firstName", user.getFirstname());
        model.addObject("lastName", user.getLastname());


        List<TakeQuiz> takeQuiz = takeQuizService.findByUserAndStartTime(user, date_tmp);
        System.out.println(takeQuiz.get(0).toString());

        model.addObject("startTime", takeQuiz.get(0).getStartTime());

        Quiz quiz = quizService.findByQuizId(quizId);
        model.addObject("quizName", quiz.getQuizName());

        // ----------get finishTime and compute score.---------
        Date finishTime = new Date();

        model.addObject("finishTime", finishTime);
        // --------compute score-------
        int score = choiceService.computeQuizScore(choiceForm);
        System.out.println("score is " + score);
        model.addObject("score", score);

        // ----------update takeQuiz for score and finishTime.---------
        int takeQuizId = takeQuiz.get(0).getTakeQuizId();
        takeQuizService.updateScoreAndFinishTime(takeQuizId, score, finishTime);

        //------------save quizResult----------
        quizResultService.saveAllChoice(choiceForm , takeQuizId);

        model.setViewName("home/result");

        return model;
    }


}
