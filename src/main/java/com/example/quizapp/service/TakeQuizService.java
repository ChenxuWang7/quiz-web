package com.example.quizapp.service;

import com.example.quizapp.model.Quiz;
import com.example.quizapp.model.TakeQuiz;
import com.example.quizapp.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TakeQuizService {
    List<TakeQuiz> findByUserAndQuiz(User user, Quiz quiz);

    void save(TakeQuiz takeQuiz);

    TakeQuiz findByTakeQuizId(int id);

    List<TakeQuiz> findByUserAndStartTime(User user, Date startTime);



    void updateScore(int id, int score);

    void updateFinishTime(int id, Date finishTime);

    void updateScoreAndFinishTime(int id, int score, Date finishTime);
}
