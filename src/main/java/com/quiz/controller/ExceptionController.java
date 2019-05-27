package com.quiz.controller;

import com.quiz.model.api.ErrorResponse;
import com.quiz.model.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletException;
import java.util.Locale;

@ControllerAdvice
public class ExceptionController {

    private final MessageSource messageSource;

    @Autowired
    public ExceptionController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> handleApplicationException(ApplicationException exception, Locale locale) {
        return new ResponseEntity<>(new ErrorResponse(exception, locale, messageSource), exception.getHttpStatus());
    }

    @ExceptionHandler({HttpMessageConversionException.class, ServletException.class})
    public ResponseEntity<ErrorResponse> handleBadRequestException(HttpMessageConversionException exception) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST, exception), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}