package com.softaria.quiz.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.softaria.quiz.model.Environment;
import com.softaria.quiz.model.ResourceLink;

public class EnvironmentResponse {

    @JsonProperty
    private String lisPersonNameFamily;

    @JsonProperty
    private String lisPersonNameGiven;

    @JsonProperty
    private String personRole;

    @JsonProperty
    private String launchView;

    @JsonProperty
    private ResourceLink resourceLink;

    public EnvironmentResponse(Environment environment) {
        lisPersonNameFamily = environment.getLisPersonNameFamily();
        lisPersonNameGiven = environment.getLisPersonNameGiven();
        personRole = environment.getPersonRole();
        launchView = environment.getLaunchView();
        resourceLink = environment.getResourceLink();
    }
}
