package com.example.quizapp.service;

import com.example.quizapp.dao.FeedbackRepository;
import com.example.quizapp.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    @Transactional
    public void save(Feedback feedback){
        feedbackRepository.save(feedback);
    }
}
