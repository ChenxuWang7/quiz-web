package com.example.quizapp.service;

import com.example.quizapp.dao.QuizRepository;
import com.example.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("quizService")
public class QuizServiceImpl implements QuizService{

    @Autowired
    private QuizRepository quizRepository;

    public List<Quiz> findAllQuizzes(){
        return quizRepository.findAll();
    }

    public Quiz findByQuizId(int quizId){return quizRepository.findByQuizId(quizId);}
}
