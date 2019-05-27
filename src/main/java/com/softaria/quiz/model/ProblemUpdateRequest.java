package com.softaria.quiz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.softaria.quiz.model.api.ProblemRequest;
import com.softaria.quiz.utils.Messages;

import javax.validation.constraints.NotNull;

public class ProblemUpdateRequest extends ProblemRequest {

    @JsonProperty
    @NotNull(message = Messages.ERROR_PROBLEM_ID_EMPTY)
    private Long problemId;

    public Long getProblemId() {
        return problemId;
    }
}
