package com.quiz.model.hibernate;


import com.quiz.model.Answer;

public class AnswerListType extends ListType {
    @Override
    public Class returnedClass() {
        return Answer.class;
    }
}
