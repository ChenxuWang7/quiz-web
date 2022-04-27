package com.example.quizapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
@Getter
@Setter
public class Question {

    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int questionId;

    //@Column(name = "quiz_id")
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @Column(name = "question_content")
    private String questionContent;

    @Column(name = "question_status")
    private String questionStatus;

    // --------------------------
//    @ManyToOne
//    @JoinColumn(name = "quiz_id")
//    private Quiz quiz;

    @OneToMany(mappedBy = "question", cascade=CascadeType.ALL)
    private List<Choice> choices;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<QuizResult> quizResults;



//    @ManyToMany(cascade=CascadeType.ALL)
//    @JoinTable(name = "quiz_result")

}
