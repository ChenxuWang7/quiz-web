package com.example.quizapp.service;

import com.example.quizapp.dao.ChoiceRepository;
import com.example.quizapp.model.Choice;
import com.example.quizapp.model.ChoiceForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("choiceService")
public class ChoiceServiceImpl implements ChoiceService{

    @Autowired
    ChoiceRepository choiceRepository;

    @Transactional
    public Choice findByChoiceId(int choiceId){
        return choiceRepository.findByChoiceId(choiceId);
    }

    @Transactional
    public boolean checkChoiceIsCorrect(int choiceId){
        return findByChoiceId(choiceId).getIsCorrect() == 1; // is_correct = 1 means correct.
    }

    @Transactional
    public int computeQuizScore(ChoiceForm choiceForm){
        List<String> choiceIds= choiceForm.getChoiceList();
        int score = 0;
        for(String s : choiceIds){
            if(s != null && checkChoiceIsCorrect(Integer.valueOf(s))){
                score++;
            }
        }
        return score;
    }


}
