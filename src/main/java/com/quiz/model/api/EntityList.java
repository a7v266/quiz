package com.quiz.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EntityList<T> {

    @JsonProperty
    private List<T> items;

    @JsonProperty
    private Long totalCount;

    public EntityList(List<T> items, Long totalCount) {
        this.items = items;
        this.totalCount = totalCount;
    }
}
