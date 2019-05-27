package com.quiz.model.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends ApplicationException {

    public ConflictException(String messageKey, Object... messageParameters) {
        super(HttpStatus.CONFLICT, messageKey, messageParameters);
    }
}
