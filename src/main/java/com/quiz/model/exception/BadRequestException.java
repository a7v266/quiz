package com.quiz.model.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ApplicationException {

    public BadRequestException(String messageKey, Object... messageParameters) {
        super(HttpStatus.BAD_REQUEST, messageKey, messageParameters);
    }
}
