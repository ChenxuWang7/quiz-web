package com.example.quizapp.service;

import com.example.quizapp.dao.ChoiceRepository;
import com.example.quizapp.dao.QuestionRepository;
import com.example.quizapp.dao.QuizResultRepository;
import com.example.quizapp.dao.TakeQuizRepository;
import com.example.quizapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("quizResultService")
public class QuizResultServiceImpl implements QuizResultService{
    @Autowired
    QuizResultRepository quizResultRepository;

    @Autowired
    ChoiceRepository choiceRepository;

    @Autowired
    TakeQuizRepository takeQuizRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Override
    @Transactional
    public void save(QuizResult quizResult){
        quizResultRepository.save(quizResult);
    }

    @Override
    @Transactional
    public void saveAllChoice(ChoiceForm form, int takeQuizId){
        List<String> choiceIds= form.getChoiceList();

        for(String s : choiceIds){
            if(s != null){
                int userSelectedChoiceId = Integer.valueOf(s);
                Choice choice = choiceRepository.findByChoiceId(userSelectedChoiceId);

                Question question = choice.getQuestion();

                TakeQuiz takeQuiz = takeQuizRepository.findByTakeQuizId(takeQuizId);


                QuizResult quizResult = new QuizResult(takeQuiz, question, userSelectedChoiceId);
                quizResultRepository.save(quizResult);
            }
        }
    }
}
