package com.quiz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quiz.utils.Messages;
import com.quiz.model.api.ProblemRequest;

import javax.validation.constraints.NotNull;

public class ProblemUpdateRequest extends ProblemRequest {

    @JsonProperty
    @NotNull(message = Messages.ERROR_PROBLEM_ID_EMPTY)
    private Long problemId;

    public Long getProblemId() {
        return problemId;
    }
}
