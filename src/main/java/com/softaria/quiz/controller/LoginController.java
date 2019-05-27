package com.softaria.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    static final String PATH_LOGIN = "/login";
    static final String PATH_LOGOUT = "/logout";
    static final String VIEW_LOGIN = "login";
    static final String REDIRECT_LOGIN = "redirect:/login";

    @RequestMapping(value = PATH_LOGIN, method = RequestMethod.GET)
    public String getLogin() {
        return VIEW_LOGIN;
    }

    @RequestMapping(value = PATH_LOGIN, method = RequestMethod.POST)
    public String postLogin() {
        return ProfileController.REDIRECT_PROFILE;
    }

    @RequestMapping(value = PATH_LOGOUT, method = RequestMethod.POST)
    public String getLogout() {
        return REDIRECT_LOGIN;
    }
}
