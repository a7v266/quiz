package com.softaria.quiz.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

@Component
public class ApplicationPropertiesImpl implements ApplicationProperties {

    @Value("${application.ui.launch.url}")
    private String uiLaunchUrl;

    @Value("${application.ui.launch.pattern}")
    private String uiLaunchPattern;

    @Value("${application.ui.launch.method}")
    private String uiLaunchMethod;

    @Value("${application.ui.websource.url}")
    private String uiWebSourceUrl;

    @Value("${application.api.path}")
    private String apiPath;

    @Value("${application.config.usePresetTopics}")
    private Boolean usePresetTopics;

    @Value("${application.config.useDefaultResourceLink}")
    private Boolean useDefaultResourceLink;

    private String uiWebSourceScheme;
    private String uiWebSourceHost;
    private int uiWebSourcePort;

    @PostConstruct
    public void init() throws MalformedURLException, URISyntaxException {
        URI url = new URI(uiWebSourceUrl);
        uiWebSourceScheme = url.getScheme();
        uiWebSourceHost = url.getHost();
        uiWebSourcePort = url.getPort();
    }

    @Override
    public String getUiLaunchUrl() {
        return uiLaunchUrl;
    }

    @Override
    public RequestMatcher getLaunchRequestMatcher() {
        return new AntPathRequestMatcher(uiLaunchPattern, uiLaunchMethod);
    }

    @Override
    public String getUiWebSourceScheme() {
        return uiWebSourceScheme;
    }

    @Override
    public String getUiWebSourceHost() {
        return uiWebSourceHost;
    }

    @Override
    public int getUiWebSourcePort() {
        return uiWebSourcePort;
    }

    @Override
    public String getApiPath() {
        return apiPath;
    }

    @Override
    public Boolean isUsedPresetTopics() {
        return usePresetTopics;
    }

    @Override
    public Boolean isUsedDefaultResourceLink() {
        return useDefaultResourceLink;
    }
}

