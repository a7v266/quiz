package com.quiz.model.search.core;

import com.quiz.utils.Format;
import com.quiz.utils.StringJoiner;

import java.io.Serializable;

public final class Field implements Serializable {

    static String path(String... names) {
        return StringJoiner.on(Format.DOT).skipEmpty().join(names);
    }
}
