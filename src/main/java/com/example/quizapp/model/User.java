package com.example.quizapp.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
//@NoArgsConstructor
//@AllArgsConstructor
@Setter
@Getter
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private int active;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Role> roles;

    //-------------------
    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<TakeQuiz> takeQuizzes;

}
