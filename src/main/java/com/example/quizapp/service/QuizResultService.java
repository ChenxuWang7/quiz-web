package com.example.quizapp.service;

import com.example.quizapp.model.ChoiceForm;
import com.example.quizapp.model.QuizResult;

public interface QuizResultService {

    void save(QuizResult quizResult);

    void saveAllChoice(ChoiceForm form, int takeQuizId);
}
