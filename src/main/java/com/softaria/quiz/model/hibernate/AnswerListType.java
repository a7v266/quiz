package com.softaria.quiz.model.hibernate;


import com.softaria.quiz.model.Answer;

public class AnswerListType extends ListType {
    @Override
    public Class returnedClass() {
        return Answer.class;
    }
}
