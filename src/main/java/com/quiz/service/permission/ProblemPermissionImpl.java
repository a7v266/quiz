package com.quiz.service.permission;

import com.quiz.model.search.core.Filter;
import com.quiz.model.search.core.Search;
import com.quiz.service.EnvironmentService;
import com.quiz.model.Problem;
import com.quiz.model.ProblemImage;
import com.quiz.model.exception.ForbiddenException;
import com.quiz.model.exception.UnprocessableEntityException;
import com.quiz.service.persistence.ProblemImagePersistence;
import com.quiz.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ProblemPermissionImpl implements ProblemPermission {

    @Autowired
    private Validator standardValidator;

    @Autowired
    private ProblemImagePersistence problemImagePersistence;

    @Override
    public void checkSave(Problem problem) {
        checkAccess(problem);
        Set<ConstraintViolation<Object>> violations = standardValidator.validate(problem);
        if (!violations.isEmpty()) {
            throw new UnprocessableEntityException(violations);
        }
    }

    @Override
    public void checkDelete(Problem problem) {
        checkAccess(problem);
        Search search = new Search();
        search.addFilter(Filter.eq(ProblemImage.PROBLEM, problem));
        ProblemImage problemImage = problemImagePersistence.first(search);
        if (problemImage != null) {
            throw new UnprocessableEntityException(Messages.ERROR_DELETE_PROBLEM_PROBLEM_IMAGE_EXISTS, problem, problemImage);
        }
    }

    @Override
    public void checkAccess(List<Problem> problems) {
        problems.forEach(this::checkAccess);
    }

    @Override
    public void checkAccess(Problem problem) {
        if (problem.isAccessDenied(EnvironmentService.getLocalUser())) {
            throw new ForbiddenException(Messages.ERROR_PROBLEM_FORBIDDEN);
        }
    }
}
