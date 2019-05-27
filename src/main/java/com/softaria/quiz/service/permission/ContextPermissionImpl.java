package com.softaria.quiz.service.permission;

import com.softaria.quiz.model.Context;
import com.softaria.quiz.model.ResourceLink;
import com.softaria.quiz.model.exception.ConflictException;
import com.softaria.quiz.model.exception.ForbiddenException;
import com.softaria.quiz.model.exception.UnprocessableEntityException;
import com.softaria.quiz.model.search.core.Filter;
import com.softaria.quiz.model.search.core.Search;
import com.softaria.quiz.service.EnvironmentService;
import com.softaria.quiz.service.persistence.ResourceLinkPersistence;
import com.softaria.quiz.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class ContextPermissionImpl implements ContextPermission {

    @Autowired
    private Validator standardValidator;

    @Autowired
    private ResourceLinkPersistence resourceLinkPersistence;

    @Override
    public void checkAccess(List<Context> contexts) {
        contexts.forEach(this::checkAccess);
    }

    @Override
    public void checkAccess(Context context) {
        if (context.isAccessDenied(EnvironmentService.getLocalUser())) {
            throw new ForbiddenException(Messages.ERROR_CONTEXT_FORBIDDEN);
        }
    }

    @Override
    public void checkSave(Context context) {
        checkAccess(context);
        Set<ConstraintViolation<Object>> violations = standardValidator.validate(context);
        if (!violations.isEmpty()) {
            throw new UnprocessableEntityException(violations);
        }
    }

    @Override
    public void checkDelete(Context context) {
        checkAccess(context);
        Search search = new Search();
        search.addFilter(Filter.eq(ResourceLink.CONTEXT, context));
        ResourceLink resourceLink = resourceLinkPersistence.first(search);
        if (resourceLink != null) {
            throw new ConflictException(Messages.ERROR_RESOURCE_LINK_EXISTS, resourceLink);
        }
    }
}
