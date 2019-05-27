package com.quiz.model.api;

import com.quiz.model.Context;

import java.util.List;

public class ContextList extends EntityList<Context> {

    public ContextList(List<Context> items, Long totalCount) {
        super(items, totalCount);
    }
}
