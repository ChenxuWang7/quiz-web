package com.example.quizapp.dao;


import com.example.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("quizRepository")
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findAll();

    List<Quiz> findByQuizName(String name);

    Quiz findByQuizId(int quizId);


}
