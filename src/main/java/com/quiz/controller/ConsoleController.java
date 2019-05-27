package com.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConsoleController {

    static final String PATH_CONSOLE = "/console";
    static final String VIEW_CONSOLE = "console";

    @RequestMapping(value = PATH_CONSOLE, method = RequestMethod.GET)
    public String viewConsole() {
        return VIEW_CONSOLE;
    }
}
