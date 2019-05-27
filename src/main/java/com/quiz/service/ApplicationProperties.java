package com.quiz.service;

import org.springframework.security.web.util.matcher.RequestMatcher;

public interface ApplicationProperties {
    String getUiLaunchUrl();

    RequestMatcher getLaunchRequestMatcher();

    String getUiWebSourceScheme();

    String getUiWebSourceHost();

    int getUiWebSourcePort();

    String getApiPath();

    Boolean isUsedPresetTopics();

    Boolean isUsedDefaultResourceLink();
}
