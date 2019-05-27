package com.softaria.quiz.controller;

import com.softaria.quiz.service.ApplicationProperties;
import com.softaria.quiz.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    static final String PATH_PROFILE = "/profile";
    static final String VIEW_PROFILE = "profile";
    static final String REDIRECT_PROFILE = "redirect:/profile";
    static final String LOCAL_USER = "localUser";
    static final String REQUEST_PARAMETERS = "requestParameters";
    static final String APPLICATION_PARAMETERS = "applicationProperties";

    @Autowired
    private ApplicationProperties applicationProperties;

    @RequestMapping(value = PATH_PROFILE, method = RequestMethod.GET)
    public String getProfile(Model model, HttpServletRequest request) {
        model.addAttribute(APPLICATION_PARAMETERS, applicationProperties);
        model.addAttribute(LOCAL_USER, EnvironmentService.getLocalUser());
        return VIEW_PROFILE;
    }
}
