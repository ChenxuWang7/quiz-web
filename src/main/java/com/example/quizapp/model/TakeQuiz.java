package com.example.quizapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "take_quiz")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TakeQuiz {

    @Id
    @Column(name = "take_quiz_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int takeQuizId;

    //@Column(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //@Column(name = "quiz_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @Column(name = "startTime")
    private Date startTime;

    @Column(name = "finishTime")
    private Date finishTime;

    @Column(name = "socre")
    private int score;


    @OneToMany(mappedBy = "takeQuiz", cascade=CascadeType.ALL) //mappedBy to the item in the Entity QuizResult.
    private List<QuizResult> quizResults;


    public TakeQuiz(User user, Quiz quiz, Date startTime){
        this.user = user;
        this.quiz = quiz;
        this.startTime = startTime;
    }
}
