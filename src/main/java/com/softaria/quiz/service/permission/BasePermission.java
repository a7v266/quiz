package com.softaria.quiz.service.permission;

import com.softaria.quiz.model.BaseEntity;
import com.softaria.quiz.model.SecureEntity;

import java.util.List;

public interface BasePermission {
    void validate(BaseEntity entity);

    void checkAccess(List<? extends SecureEntity> entities);

    void checkAccess(SecureEntity entity);
}
