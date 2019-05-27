package com.softaria.quiz.model.search.core;

import com.softaria.quiz.utils.Assert;
import com.softaria.quiz.utils.Format;
import com.softaria.quiz.utils.StringJoiner;

import java.io.Serializable;

public class Sort implements Serializable {

    private String property;
    private Boolean desc;

    public static Sort create(String property, Boolean desc) {
        Assert.notEmpty(property);
        return new Sort(property, desc);
    }

    public static Sort asc(String property) {
        Assert.notEmpty(property);
        return new Sort(property);
    }

    public static Sort desc(String property) {
        Assert.notEmpty(property);
        return new Sort(property, Boolean.TRUE);
    }

    private Sort(String property) {
        this.property = property;
    }

    private Sort(String property, Boolean desc) {
        this.property = property;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return StringJoiner
                .on(Format.DOT, Format.OPENING_PARENTHESIS, Format.CLOSING_PARENTHESIS)
                .skipEmpty()
                .join(property, desc);
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public boolean isDesc() {
        return desc != null ? desc : false;
    }
}
