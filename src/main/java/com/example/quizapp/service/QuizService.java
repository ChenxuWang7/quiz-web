package com.example.quizapp.service;

import com.example.quizapp.model.Quiz;

import java.util.List;

public interface QuizService {
    List<Quiz> findAllQuizzes();

    Quiz findByQuizId(int quizId);
}
