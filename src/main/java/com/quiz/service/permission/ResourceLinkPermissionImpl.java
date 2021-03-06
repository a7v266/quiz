package com.quiz.service.permission;

import com.quiz.model.search.core.Filter;
import com.quiz.model.search.core.Search;
import com.quiz.model.Problem;
import com.quiz.model.ResourceLink;
import com.quiz.model.exception.ConflictException;
import com.quiz.service.persistence.ProblemPersistence;
import com.quiz.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ResourceLinkPermissionImpl extends BasePermissionImpl implements ResourceLinkPermission {

    @Autowired
    private ProblemPersistence problemPersistence;

    @Override
    public void checkSave(ResourceLink resourceLink) {
        checkAccess(resourceLink);
        validate(resourceLink);
    }

    @Override
    public void checkDelete(ResourceLink resourceLink) {
        checkAccess(resourceLink);
        Search search = new Search();
        search.addFilter(Filter.eq(Problem.RESOURCE_LINK, resourceLink));
        Problem problem = problemPersistence.first(search);
        if (problem != null) {
            throw new ConflictException(Messages.ERROR_PROBLEM_EXISTS, problem);
        }
    }
}
