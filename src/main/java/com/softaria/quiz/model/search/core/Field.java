package com.softaria.quiz.model.search.core;

import com.softaria.quiz.utils.Format;
import com.softaria.quiz.utils.StringJoiner;

import java.io.Serializable;

public final class Field implements Serializable {

    static String path(String... names) {
        return StringJoiner.on(Format.DOT).skipEmpty().join(names);
    }
}
