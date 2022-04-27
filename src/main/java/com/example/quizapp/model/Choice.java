package com.example.quizapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "choice")
@Getter
@Setter
public class Choice {

    @Id
    @Column(name = "choice_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int choiceId;

    //@Column(name = "question_id")
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "choice_content")
    private String choiceContent;

    @Column(name = "is_correct")
    private int isCorrect;

    //-----------------------


}
