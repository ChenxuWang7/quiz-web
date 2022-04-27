package com.example.quizapp.service;

import com.example.quizapp.model.Choice;
import com.example.quizapp.model.ChoiceForm;

public interface ChoiceService {
    Choice findByChoiceId(int choiceId);

    boolean checkChoiceIsCorrect(int choiceId);

    int computeQuizScore(ChoiceForm choiceForm);
}
