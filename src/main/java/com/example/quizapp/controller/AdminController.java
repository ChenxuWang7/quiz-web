package com.example.quizapp.controller;

import com.example.quizapp.model.User;
import com.example.quizapp.service.QuizService;
import com.example.quizapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    QuizService quizService;


    @RequestMapping(value= {"/admin/admin_home"}, method=RequestMethod.GET)
    public ModelAndView admin_home() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Admin home's visitor is " + auth.getAuthorities());
        User user = userService.findUserByEmail(auth.getName());

        model.addObject("userName", user.getFirstname() + " " + user.getLastname());

        List<User> userList = userService.findAll();
        for(User u: userList){
            System.out.println(u.showUser());
        }

        // --------show all users----------
        model.addObject("userList", userList);


        model.setViewName("admin/admin_home");
        return model;
    }

    @RequestMapping(value= {"/admin/toggleUserStatus/{userId}"}, method=RequestMethod.GET)
    public ModelAndView toggleUserStatusReturn() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Admin home's visitor is " + auth.getAuthorities());
        User user = userService.findUserByEmail(auth.getName());

        model.addObject("userName", user.getFirstname() + " " + user.getLastname());

        List<User> userList = userService.findAll();
        for(User u: userList){
            System.out.println(u.showUser());
        }

        // --------show all users----------
        model.addObject("userList", userList);


        model.setViewName("admin/admin_home");
        return model;
    }

    @RequestMapping(value= {"/admin/toggleUserStatus/{userId}"}, method=RequestMethod.POST)
    public ModelAndView toggleUserStatus(@PathVariable int userId) {
        ModelAndView model = new ModelAndView();

//        //--------show user name--------
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("Admin home's visitor is " + auth.getAuthorities());
//        User user = userService.findUserByEmail(auth.getName());
//        model.addObject("userName", user.getFirstname() + " " + user.getLastname());
//
//        //---------toggle picked user's status--------
//
        System.out.println("userId" + userId + "will be toggle status.");

//
//
//        // --------show all users----------
//        List<User> userList = userService.findAll();
//        model.addObject("userList", userList);

        model.setViewName("admin/admin_home");
        return model;
    }
}
