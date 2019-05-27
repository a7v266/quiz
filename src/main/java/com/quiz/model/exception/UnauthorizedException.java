package com.quiz.model.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ApplicationException {

    public UnauthorizedException(String messageKey, Object... messageParameters) {
        super(HttpStatus.UNAUTHORIZED, messageKey, messageParameters);
    }
}
