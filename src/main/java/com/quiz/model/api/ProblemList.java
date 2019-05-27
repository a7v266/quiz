package com.quiz.model.api;

import com.quiz.model.Problem;

import java.util.List;

public class ProblemList extends EntityList<Problem> {

    public ProblemList(List<Problem> items, Long totalCount) {
        super(items, totalCount);
    }
}
