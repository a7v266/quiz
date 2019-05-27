package com.softaria.quiz.model.exception;

import com.softaria.quiz.utils.CollectionUtils;
import org.springframework.http.HttpStatus;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

public class ApplicationException extends RuntimeException {

    private HttpStatus httpStatus;
    private List<ErrorMessage> errorMessages = CollectionUtils.createArrayList();

    public ApplicationException(Exception exception) {
        super(exception);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ApplicationException(String messageKey, Object... messageParameters) {
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        errorMessages.add(new ErrorMessage(messageKey, messageParameters));
    }

    public ApplicationException(HttpStatus httpStatus, String messageKey, Object... messageParameters) {
        this.httpStatus = httpStatus;
        errorMessages.add(new ErrorMessage(messageKey, messageParameters));
    }

    public ApplicationException(HttpStatus httpStatus, Set<ConstraintViolation<Object>> violations) {
        this.httpStatus = httpStatus;
        for (ConstraintViolation<?> violation : violations) {
            errorMessages.add(new ErrorMessage(violation.getMessage()));
        }
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public List<ErrorMessage> getErrorMessages() {
        return errorMessages;
    }

    public Integer getHttpStatusValue() {
        return httpStatus != null ? httpStatus.value() : null;
    }

    public static class ErrorMessage {

        private String messageKey;

        private Object[] messageParameters;

        public ErrorMessage(String messageKey, Object... messageParameters) {
            this.messageKey = messageKey;
            this.messageParameters = messageParameters;
        }

        public String getMessageKey() {
            return messageKey;
        }

        public Object[] getMessageParameters() {
            return messageParameters;
        }
    }
}
