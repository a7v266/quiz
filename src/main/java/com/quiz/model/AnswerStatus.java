package com.quiz.model;

import com.quiz.utils.Messages;

public enum AnswerStatus implements Identifiable {

    UNCHECKED(1L, Messages.DESCRIPTION_ANSWER_STATUS_UNCHECKED),
    VALID(2L, Messages.DESCRIPTION_ANSWER_STATUS_VALID),
    INVALID(3L, Messages.DESCRIPTION_ANSWER_STATUS_INVALID);

    private Long id;
    private String title;

    AnswerStatus(Long id, String title) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
