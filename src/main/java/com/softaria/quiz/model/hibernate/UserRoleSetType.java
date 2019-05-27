package com.softaria.quiz.model.hibernate;


import com.softaria.quiz.model.UserRole;

public class UserRoleSetType extends SetType {

    @Override
    public Class returnedClass() {
        return UserRole.class;
    }
}
