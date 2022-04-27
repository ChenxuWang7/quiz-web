package com.example.quizapp.service;

import com.example.quizapp.dao.TakeQuizRepository;
import com.example.quizapp.model.Quiz;
import com.example.quizapp.model.TakeQuiz;
import com.example.quizapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("takeQuizService")
public class TakeQuizServiceImpl implements TakeQuizService{

    @Autowired
    private TakeQuizRepository takeQuizRepository;

    @Override
    @Transactional
    public List<TakeQuiz> findByUserAndQuiz(User user, Quiz quiz){
        return takeQuizRepository.findByUserAndQuiz(user, quiz);
    }

    @Override
    @Transactional
    public void save(TakeQuiz takeQuiz){
        takeQuizRepository.save(takeQuiz);
    }

    @Override
    @Transactional
    public TakeQuiz findByTakeQuizId(int id){
        return takeQuizRepository.findByTakeQuizId(id);
    }

    @Override
    @Transactional
    public List<TakeQuiz> findByUserAndStartTime(User user, Date startTime){
        return takeQuizRepository.findByUserAndStartTime(user, startTime);
    }


    @Override
    @Transactional
    public void updateScore(int id, int score){
        takeQuizRepository.updateScore(id, score);
    }


    @Override
    @Transactional
    public void updateFinishTime(int id, Date finishTime){
        takeQuizRepository.updateFinishTime(id, finishTime);
    }


    @Override
    @Transactional
    public void updateScoreAndFinishTime(int id, int score, Date finishTime){
        takeQuizRepository.updateScore(id, score);
        takeQuizRepository.updateFinishTime(id, finishTime);
    }

}
