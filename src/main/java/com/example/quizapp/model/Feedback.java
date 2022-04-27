package com.example.quizapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
@Getter
@Setter
public class Feedback {

    @Id
    @Column(name = "feedback_id")
    private int feedbackId;

    //@Column(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //@Column(name = "quiz_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @Column(name = "rating")
    private int rating;

    @Column(name = "review")
    private String review;


}
