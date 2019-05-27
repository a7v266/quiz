package com.softaria.quiz.model;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {

    ROLE_USER_VIEW,
    ROLE_USER_SAVE,
    ROLE_USER_DELETE,

    ROLE_USER_GROUP_VIEW,
    ROLE_USER_GROUP_SAVE,
    ROLE_USER_GROUP_DELETE,

    ROLE_PROBLEM_VIEW,
    ROLE_PROBLEM_SAVE,
    ROLE_PROBLEM_DELETE,

    ROLE_SOLUTION_VIEW,
    ROLE_SOLUTION_SAVE,
    ROLE_SOLUTION_DELETE;

    @Override
    public String getAuthority() {
        return name();
    }
}
