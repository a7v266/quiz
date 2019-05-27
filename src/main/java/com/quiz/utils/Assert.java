package com.quiz.utils;

public class Assert {

    private static final String ERROR_EMPTY_VALUE = "{error.assert.emptyValue}";

    public static void notEmpty(String value) {
        if (StringUtils.isEmpty(value)) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }
    }

    public static void notEmpty(Object value) {
        if (ObjectUtils.isEmpty(value)) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }
    }
}
