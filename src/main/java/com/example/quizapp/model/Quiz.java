package com.example.quizapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "quiz")
@Getter
@Setter
//@ToString //throw : java.lang.stackoverflowerror: null
public class Quiz {

    @Id
    @Column(name = "quiz_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int quizId;

    @Column(name = "quiz_name")
    private String quizName;

    @Column(name = "quiz_description")
    private String quizDescription;

    //-----------
    @OneToMany(mappedBy = "quiz", cascade=CascadeType.ALL)
    private List<Question> questions;

    @OneToMany(mappedBy = "quiz", cascade=CascadeType.ALL)
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<TakeQuiz> takeQuizzes;


}
