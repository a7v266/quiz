package com.quiz.model.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ApplicationException {

    public NotFoundException(String messageKey, Object... messageParameters) {
        super(HttpStatus.NOT_FOUND, messageKey, messageParameters);
    }
}
