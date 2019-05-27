package com.softaria.quiz.service.security;

import com.softaria.quiz.service.ApplicationProperties;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;

public class LtiAuthenticationSuccessHandler extends ForwardAuthenticationSuccessHandler {

    public LtiAuthenticationSuccessHandler(ApplicationProperties applicationProperties) {
        super(applicationProperties.getUiLaunchUrl());
    }
}
