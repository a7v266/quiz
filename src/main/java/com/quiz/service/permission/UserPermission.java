package com.quiz.service.permission;


import com.quiz.model.LocalUser;

public interface UserPermission {

    void checkRegisterUser(LocalUser user);
}
