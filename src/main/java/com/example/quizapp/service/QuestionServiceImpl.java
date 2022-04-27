package com.example.quizapp.service;

import com.example.quizapp.dao.QuestionRepository;
import com.example.quizapp.model.Question;
import com.example.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    @Transactional
    public List<Question> findByQuiz(Quiz quiz){
        return questionRepository.findByQuiz(quiz);
    }

    @Override
    @Transactional
    public Question findByQuestionId(int questionId){
        return questionRepository.findByQuestionId(questionId);
    }
}
