package com.quiz.model.hibernate;


import com.quiz.model.UserRole;

public class UserRoleSetType extends SetType {

    @Override
    public Class returnedClass() {
        return UserRole.class;
    }
}
