package com.softaria.quiz.service;

import com.softaria.quiz.model.Environment;
import com.softaria.quiz.model.LaunchRequest;
import com.softaria.quiz.model.LocalUser;
import com.softaria.quiz.model.ResourceLink;
import com.softaria.quiz.model.api.EnvironmentRequest;
import com.softaria.quiz.model.api.EnvironmentResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public interface EnvironmentService {

    static Environment getEnvironment() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication instanceof Environment) {
            return (Environment) authentication;
        }
        return null;
    }

    static LocalUser getLocalUser() {
        Environment environment = getEnvironment();
        return environment != null ? environment.getLocalUser() : null;
    }

    static Long getLocalUserId() {
        LocalUser localUser = getLocalUser();
        return localUser != null ? localUser.getId() : null;
    }

    static ResourceLink getResourceLink() {
        Environment environment = getEnvironment();
        return environment != null ? environment.getResourceLink() : null;
    }

    static Long getResourceLinkId() {
        ResourceLink resourceLink = getResourceLink();
        return resourceLink != null ? resourceLink.getId() : null;
    }

    Environment createEnvironment(LocalUser user);

    Environment createEnvironment(LocalUser user, LaunchRequest launchRequest);

    EnvironmentResponse readEnvironment();

    EnvironmentResponse updateEnvironment(EnvironmentRequest request);
}
