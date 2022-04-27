package com.example.quizapp.dao;

import com.example.quizapp.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("feedbackRepository")
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
