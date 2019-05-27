package com.quiz.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quiz.utils.Format;
import com.quiz.utils.StringJoiner;
import com.quiz.model.exception.ApplicationException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ErrorResponse {

    @JsonProperty
    private long timestamp;

    @JsonProperty
    private int status;

    @JsonProperty
    private String error;

    @JsonProperty
    private String message;

    @JsonProperty
    private List<ErrorMessage> messages;

    @JsonProperty
    private List<StackTraceMessage> stackTrace;

    public ErrorResponse(HttpStatus httpStatus, Exception exception) {
        timestamp = Instant.now().toEpochMilli();
        status = httpStatus.value();
        error = httpStatus.getReasonPhrase();
        message = StringJoiner
                .on(Format.COLON_SPACE)
                .skipEmpty()
                .join(exception.getClass().getName(), exception.getMessage());
        stackTrace = Arrays
                .stream(exception.getStackTrace())
                .map(StackTraceMessage::new)
                .collect(Collectors.toList());
    }

    public ErrorResponse(ApplicationException exception, Locale locale, MessageSource messageSource) {
        this(exception.getHttpStatus(), exception);

        messages = exception.getErrorMessages()
                .stream()
                .map(item -> new ErrorMessage(
                        item.getMessageKey(),
                        messageSource.getMessage(
                                item.getMessageKey(),
                                item.getMessageParameters(),
                                item.getMessageKey(),
                                locale)))
                .collect(Collectors.toList());

        messages.stream().findFirst().ifPresent(errorMessage -> message = errorMessage.description);
    }

    private static class ErrorMessage {

        @JsonProperty
        String code;

        @JsonProperty
        String description;

        ErrorMessage(String code, String description) {
            this.code = code;
            this.description = description;
        }
    }

    private static class StackTraceMessage {

        @JsonProperty
        private String className;

        @JsonProperty
        private String methodName;

        @JsonProperty
        private String fileName;

        @JsonProperty
        private int lineNumber;

        StackTraceMessage(StackTraceElement element) {
            className = element.getClassName();
            methodName = element.getMethodName();
            fileName = element.getFileName();
            lineNumber = element.getLineNumber();
        }
    }
}
