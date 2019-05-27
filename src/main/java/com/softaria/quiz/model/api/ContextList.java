package com.softaria.quiz.model.api;

import com.softaria.quiz.model.Context;

import java.util.List;

public class ContextList extends EntityList<Context> {

    public ContextList(List<Context> items, Long totalCount) {
        super(items, totalCount);
    }
}
