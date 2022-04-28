package com.example.quizapp.controller;

import com.example.quizapp.dao.UserRepository;
import com.example.quizapp.model.Feedback;
import com.example.quizapp.model.Quiz;
import com.example.quizapp.model.User;
import com.example.quizapp.service.FeedbackService;
import com.example.quizapp.service.QuizService;
import com.example.quizapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class FeedbackController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuizService quizService;

    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping(value= {"/feedback"}, method= RequestMethod.GET)
    public ModelAndView feedback() {
        ModelAndView model = new ModelAndView();

        model.setViewName("home/feedback");
        return model;
    }
    @RequestMapping(value= {"/feedback/submit"}, method= RequestMethod.POST)
    public ModelAndView feedbackSubmit(@RequestParam(name = "feedback") String feedback,
                                       @RequestParam(name = "rating") String rating,
                                       @RequestParam(name = "quizType") String quizType) {
        ModelAndView model = new ModelAndView();
        // ------get user------
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("User Home's visitor is " + auth.getAuthorities());
        User user = userService.findUserByEmail(auth.getName());

        System.out.println(quizType);
        System.out.println(feedback);
        System.out.println(rating);

        Quiz quiz = quizService.findByQuizId(Integer.valueOf(quizType));

        Feedback newFeedback = new Feedback(user,quiz,Integer.valueOf(rating), feedback);


        feedbackService.save(newFeedback);




        model.setViewName("home/home");
        return model;
    }

    @RequestMapping(value= {"/contactus"}, method= RequestMethod.GET)
    public ModelAndView contactus() {
        ModelAndView model = new ModelAndView();

        model.setViewName("home/contactus");
        return model;
    }
}
