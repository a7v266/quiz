package com.softaria.quiz.model.validation;


import com.softaria.quiz.utils.Messages;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = AnswerListValidator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface AnswerListConstraint {

    String message() default Messages.ERROR_ANSWER_VALUE_DUPLICATE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
