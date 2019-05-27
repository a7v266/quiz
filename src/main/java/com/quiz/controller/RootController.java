package com.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RootController {

    private static final String PATH_ROOT = "/";

    @RequestMapping(value = PATH_ROOT, method = RequestMethod.GET)
    public String getRoot() {
        return ProfileController.REDIRECT_PROFILE;
    }
}
