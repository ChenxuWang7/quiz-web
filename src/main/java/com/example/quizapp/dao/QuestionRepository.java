package com.example.quizapp.dao;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("questionRepository")
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuiz(Quiz quiz);

    Question findByQuestionId(int questionId);

}
