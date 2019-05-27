package com.quiz.model.exception;

import com.quiz.utils.Messages;
import org.springframework.security.authentication.BadCredentialsException;

public class ConsumerKeyNotFoundException extends BadCredentialsException {

    private String consumerKey;

    public ConsumerKeyNotFoundException(String consumerKey) {
        super(Messages.ERROR_AUTHENTICATION_CONSUMER_KEY_NOT_FOUND);
        this.consumerKey = consumerKey;
    }
}
