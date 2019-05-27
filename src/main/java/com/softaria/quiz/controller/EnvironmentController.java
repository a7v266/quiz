package com.softaria.quiz.controller;

import com.softaria.quiz.model.api.EnvironmentRequest;
import com.softaria.quiz.model.api.EnvironmentResponse;
import com.softaria.quiz.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EnvironmentController {

    private static final String PATH_API_ENVIRONMENT = "/api/environment";

    @Autowired
    private EnvironmentService environmentService;

    @RequestMapping(value = PATH_API_ENVIRONMENT, method = RequestMethod.GET)
    public EnvironmentResponse readEnvironment() {
        return environmentService.readEnvironment();
    }

    @RequestMapping(value = PATH_API_ENVIRONMENT, method = RequestMethod.PUT)
    public EnvironmentResponse updateEnvironment(@RequestBody @Valid EnvironmentRequest request) {
        return environmentService.updateEnvironment(request);
    }
}
