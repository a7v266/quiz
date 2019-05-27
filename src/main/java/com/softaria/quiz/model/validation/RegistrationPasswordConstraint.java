package com.softaria.quiz.model.validation;


import com.softaria.quiz.utils.Messages;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = RegistractionPasswordValidator.class)
@Documented
public @interface RegistrationPasswordConstraint {

    String message() default Messages.ERROR_REGISTRATION_PASSWORD_INVALID;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
