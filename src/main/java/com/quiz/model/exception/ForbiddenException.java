package com.quiz.model.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends ApplicationException {

    public ForbiddenException(String messageKey, Object... messageParameters) {
        super(HttpStatus.FORBIDDEN, messageKey, messageParameters);
    }
}
