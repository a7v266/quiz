package com.softaria.quiz.service.permission;


import com.softaria.quiz.model.BaseEntity;
import com.softaria.quiz.model.SecureEntity;
import com.softaria.quiz.model.exception.ForbiddenException;
import com.softaria.quiz.model.exception.UnprocessableEntityException;
import com.softaria.quiz.service.EnvironmentService;
import com.softaria.quiz.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

public class BasePermissionImpl implements BasePermission {

    @Autowired
    private Validator standardValidator;

    @Override
    public void validate(BaseEntity entity) {
        Set<ConstraintViolation<Object>> violations = standardValidator.validate(entity);
        if (!violations.isEmpty()) {
            throw new UnprocessableEntityException(violations);
        }
    }

    @Override
    public void checkAccess(List<? extends SecureEntity> entities) {
        entities.forEach(this::checkAccess);
    }

    @Override
    public void checkAccess(SecureEntity entity) {
        if (entity.isAccessDenied(EnvironmentService.getLocalUser())) {
            throw new ForbiddenException(Messages.ERROR_PROBLEM_FORBIDDEN);
        }
    }
}
