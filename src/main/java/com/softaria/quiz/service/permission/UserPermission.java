package com.softaria.quiz.service.permission;


import com.softaria.quiz.model.LocalUser;

public interface UserPermission {

    void checkRegisterUser(LocalUser user);
}
