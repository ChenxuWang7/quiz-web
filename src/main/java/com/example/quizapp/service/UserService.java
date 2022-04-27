package com.example.quizapp.service;

import com.example.quizapp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  {
    User findUserByEmail(String email);

    void saveUser(User user);
}
