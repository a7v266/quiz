package com.softaria.quiz.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnvironmentRequest {

    @JsonProperty
    private Long resourceLinkId;

    public Long getResourceLinkId() {
        return resourceLinkId;
    }
}
