package com.softaria.quiz.service.permission;

import com.softaria.quiz.model.LocalUser;
import com.softaria.quiz.model.exception.UnprocessableEntityException;
import com.softaria.quiz.service.persistence.UserPersistence;
import com.softaria.quiz.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
@Transactional
public class UserPermissionImpl implements UserPermission {

    @Autowired
    private Validator standardValidator;

    @Autowired
    private UserPersistence userPersistence;

    @Override
    public void checkRegisterUser(LocalUser user) {
        Set<ConstraintViolation<Object>> violations = standardValidator.validate(user);
        if (!violations.isEmpty()) {
            throw new UnprocessableEntityException(violations);
        }
        LocalUser duplicateUser = userPersistence.findByUsername(user.getUsername());
        if (duplicateUser != null) {
            throw new UnprocessableEntityException(Messages.ERROR_REGISTER_USER_DUPLICATE_USERNAME, user.getUsername());
        }
    }
}
