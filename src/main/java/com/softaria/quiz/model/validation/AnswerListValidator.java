package com.softaria.quiz.model.validation;

import com.softaria.quiz.model.Answer;
import com.softaria.quiz.utils.CollectionUtils;
import com.softaria.quiz.utils.Messages;
import com.softaria.quiz.utils.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Set;

public class AnswerListValidator implements ConstraintValidator<AnswerListConstraint, List<Answer>> {

    @Override
    public void initialize(AnswerListConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(List<Answer> answers, ConstraintValidatorContext context) {
        if (answers == null || answers.isEmpty()) {
            return true;
        }
        Set<String> values = CollectionUtils.createHashSet();
        for (Answer answer : answers) {
            if (StringUtils.isEmpty(answer.getAnswerValue())) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(Messages.ERROR_ANSWER_VALUE_EMPTY).addConstraintViolation();
                return false;
            }
            if (answer.getAnswerStatus() == null) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(Messages.ERROR_ANSWER_STATUS_EMPTY).addConstraintViolation();
                return false;
            }
            if (values.contains(answer.getAnswerValue())) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(Messages.ERROR_ANSWER_VALUE_DUPLICATE).addConstraintViolation();
                return false;
            }
            values.add(answer.getAnswerValue());
        }
        return true;
    }
}
