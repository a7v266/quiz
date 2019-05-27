package com.quiz.controller;

import com.quiz.service.UserService;
import com.quiz.model.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    static final String PATH_REGISTRATION = "/registration";
    static final String VIEW_REGISTRATION = "registration";

    @Autowired
    private UserService userService;

    @RequestMapping(value = PATH_REGISTRATION, method = RequestMethod.GET)
    public String getRegistration() {
        return VIEW_REGISTRATION;
    }

    @RequestMapping(value = PATH_REGISTRATION, method = RequestMethod.POST)
    public String postRegistration(@ModelAttribute @Valid RegistrationRequest request) {
        userService.registerUser(request);
        return LoginController.REDIRECT_LOGIN;
    }
}
