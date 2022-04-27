package com.example.quizapp.dao;

import com.example.quizapp.model.Choice;
import com.example.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("choiceRepository")
public interface ChoiceRepository extends JpaRepository<Choice, Long> {
    Choice findByChoiceId(int choiceId);
}
