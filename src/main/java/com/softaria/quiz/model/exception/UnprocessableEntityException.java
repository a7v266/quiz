package com.softaria.quiz.model.exception;

import org.springframework.http.HttpStatus;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class UnprocessableEntityException extends ApplicationException {

    public UnprocessableEntityException(String messageKey, Object... messageParameters) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, messageKey, messageParameters);
    }

    public UnprocessableEntityException(Set<ConstraintViolation<Object>> violations) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, violations);
    }
}
