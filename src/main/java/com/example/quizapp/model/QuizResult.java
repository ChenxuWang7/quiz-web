package com.example.quizapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "quiz_result")
@Getter
@Setter
@NoArgsConstructor
public class QuizResult {

    @Id
    @Column(name = "quiz_result_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int quizResultId;

    //@Column(name = "take_quiz_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "take_quiz_id")
    private TakeQuiz takeQuiz;

    //@Column(name = "question_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "user_choice")
    private int userChoice;

    public QuizResult(TakeQuiz takeQuiz, Question question, int userChoice){
        this.takeQuiz = takeQuiz;
        this.question = question;
        this.userChoice = userChoice;
    }

}
