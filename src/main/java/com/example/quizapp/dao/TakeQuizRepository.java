package com.example.quizapp.dao;

import com.example.quizapp.model.Quiz;
import com.example.quizapp.model.TakeQuiz;
import com.example.quizapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("takeQuizRepository")
public interface TakeQuizRepository extends JpaRepository<TakeQuiz, Long> {
    List<TakeQuiz> findByUserAndQuiz(User user, Quiz quiz);

    TakeQuiz findByTakeQuizId(int id);

    List<TakeQuiz> findByUserAndStartTime(User user, Date startTime);

    @Modifying
    @Query("update TakeQuiz t set t.score = :score where t.takeQuizId = :id")
    void updateScore(@Param(value = "id") int id, @Param(value = "score") int score);

    @Modifying
    @Query("update TakeQuiz t set t.finishTime = :finishTime where t.takeQuizId = :id")
    void updateFinishTime(@Param(value = "id") int id, @Param(value = "finishTime") Date finishTime);
}
