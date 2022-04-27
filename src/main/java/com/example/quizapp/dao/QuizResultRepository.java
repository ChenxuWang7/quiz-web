package com.example.quizapp.dao;

import com.example.quizapp.model.QuizResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("quizResultRepository")
public interface QuizResultRepository extends JpaRepository<QuizResult, Long> {

}
