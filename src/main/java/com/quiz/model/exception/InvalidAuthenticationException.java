package com.quiz.model.exception;

import org.springframework.security.core.AuthenticationException;

public class InvalidAuthenticationException extends AuthenticationException {

    public InvalidAuthenticationException(String errorMessage) {
        super(errorMessage);
    }
}
