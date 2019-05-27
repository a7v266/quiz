package com.softaria.quiz.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public abstract class AbstractList<T> {

    @JsonProperty
    private List<T> items;

    @JsonProperty
    private Long totalCount;

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
