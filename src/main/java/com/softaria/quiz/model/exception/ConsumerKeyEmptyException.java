package com.softaria.quiz.model.exception;

import com.softaria.quiz.utils.Messages;
import org.springframework.security.authentication.BadCredentialsException;

public class ConsumerKeyEmptyException extends BadCredentialsException {

    public ConsumerKeyEmptyException() {
        super(Messages.ERROR_AUTHENTICATION_CONSUMER_KEY_EMPTY);
    }
}
