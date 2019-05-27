package com.softaria.quiz.utils;

import com.softaria.quiz.model.Identifiable;

public class EnumUtils {

    public static <T extends Identifiable> T getEnum(Long id, Class<T> clazz) {
        if (id == null) {
            return null;
        }
        for (T value : clazz.getEnumConstants()) {
            if (id.equals(value.getId())) {
                return value;
            }
        }
        return null;
    }
}
