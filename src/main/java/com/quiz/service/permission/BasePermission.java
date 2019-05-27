package com.quiz.service.permission;

import com.quiz.model.BaseEntity;
import com.quiz.model.SecureEntity;

import java.util.List;

public interface BasePermission {
    void validate(BaseEntity entity);

    void checkAccess(List<? extends SecureEntity> entities);

    void checkAccess(SecureEntity entity);
}
