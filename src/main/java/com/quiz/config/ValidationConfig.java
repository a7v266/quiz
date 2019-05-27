package com.quiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
public class ValidationConfig {

    @Bean
    public Validator standardValidator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }
}
