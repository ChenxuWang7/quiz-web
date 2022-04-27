package com.example.quizapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.quizapp.model.Quiz;
import com.example.quizapp.model.TakeQuiz;
import com.example.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.quizapp.model.User;
import com.example.quizapp.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuizService quizService;

    @RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();

        model.setViewName("user/login");
        return model;
    }

    //--------------------------
    @RequestMapping("/default")
    public String defaultAfterLogin() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("The default entry's visitor" + auth.getAuthorities());

        if(auth.getAuthorities().toString().equals("[ADMIN]")) {
            System.out.println("Admin has came in");
            return "redirect:/admin/admin_home";
        }
        return "redirect:/home/home";
    }

    @RequestMapping(value= {"/admin/admin_home"}, method=RequestMethod.GET)
    public ModelAndView admin_home() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Admin home's visitor is " + auth.getAuthorities());
        User user = userService.findUserByEmail(auth.getName());

        model.addObject("userName", user.getFirstname() + " " + user.getLastname());
        model.setViewName("admin/admin_home");
        return model;
    }

    //--------------------------


    @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView model = new ModelAndView();
        User user = new User();
        model.addObject("user", user);
        model.setViewName("user/signup");

        return model;
    }

    @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());

        if(userExists != null) {
            bindingResult.rejectValue("email", "error.user", "This email already exists!");
        }
        if(bindingResult.hasErrors()) {
            model.setViewName("user/signup");
        } else {
            userService.saveUser(user);
            model.addObject("msg", "User has been registered successfully!");
            model.addObject("user", new User());
            //model.setViewName("user/signup");
            model.setViewName("home/home");
        }

        return model;
    }

    @RequestMapping(value= {"/home/home"}, method=RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("User Home's visitor is " + auth.getAuthorities());
        User user = userService.findUserByEmail(auth.getName());

        model.addObject("userName", user.getFirstname() + " " + user.getLastname());

        //---------------quiz part----------------
        List<Quiz> allQuizzes = quizService.findAllQuizzes();
        System.out.println(allQuizzes);
        model.addObject("allQuizzes", allQuizzes);

        //----------show the quiz records for user----------
        List<TakeQuiz> takeQuizzes = user.getTakeQuizzes();
        model.addObject("takeQuizzes", takeQuizzes);

        model.setViewName("home/home");
        return model;
    }


    @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView();
        model.setViewName("errors/access_denied");
        return model;
    }
}