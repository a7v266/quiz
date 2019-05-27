package com.softaria.quiz.model.validation;

import com.softaria.quiz.utils.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegistractionPasswordValidator implements ConstraintValidator<RegistrationPasswordConstraint, RegistrationPasswordValidated> {

    @Override
    public void initialize(RegistrationPasswordConstraint constraint) {
    }

    @Override
    public boolean isValid(RegistrationPasswordValidated source, ConstraintValidatorContext context) {

        return ObjectUtils.equals(source.getPassword1(), source.getPassword2());
    }
}
