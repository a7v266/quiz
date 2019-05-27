package com.softaria.quiz.service;

import com.softaria.quiz.model.*;
import com.softaria.quiz.model.api.EnvironmentRequest;
import com.softaria.quiz.model.api.EnvironmentResponse;
import com.softaria.quiz.model.exception.ForbiddenException;
import com.softaria.quiz.model.exception.NotFoundException;
import com.softaria.quiz.model.search.core.Filter;
import com.softaria.quiz.model.search.core.Search;
import com.softaria.quiz.service.persistence.ContextPersistence;
import com.softaria.quiz.service.persistence.LaunchRequestPersistence;
import com.softaria.quiz.service.persistence.ResourceLinkPersistence;
import com.softaria.quiz.utils.Messages;
import com.softaria.quiz.utils.ObjectUtils;
import com.softaria.quiz.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnvironmentServiceImpl implements EnvironmentService {

    @Autowired
    private ContextPersistence contextPersistence;

    @Autowired
    private ResourceLinkPersistence resourceLinkPersistence;

    @Autowired
    private LaunchRequestPersistence launchRequestPersistence;

    @Override
    public Environment createEnvironment(LocalUser localUser) {
        return new Environment(localUser);
    }

    @Override
    @Transactional
    public Environment createEnvironment(LocalUser localUser, LaunchRequest launchRequest) {

        launchRequestPersistence.save(launchRequest);

        if (StringUtils.isEmpty(launchRequest.getResourceLinkId())) {
            throw new ForbiddenException(Messages.ERROR_RESOURCE_LINK_ID_EMPTY);
        }

        Search search = new Search();
        search.addFilter(Filter.eq(ResourceLink.RESOURCE_LINK_ID, launchRequest.getResourceLinkId()));
        ResourceLink resourceLink = resourceLinkPersistence.uniqueResult(search);

        if (resourceLink == null) {

            Context context = launchRequest.createContext();
            context.setLocalUserId(localUser.getId());
            contextPersistence.save(context);

            resourceLink = launchRequest.createResourceLink();
            resourceLink.setContext(context);
            resourceLink.setLocalUserId(localUser.getId());
            resourceLinkPersistence.save(resourceLink);

        } else {

            Context context = resourceLink.getContext();
            launchRequest.updateContext(context);
            if (ObjectUtils.notEquals(context.getLocalUserId(), localUser.getId())) {
                throw new ForbiddenException(Messages.ERROR_CONTEXT_FORBIDDEN, context);
            }
            contextPersistence.update(context);

            launchRequest.updateResourceLink(resourceLink);
            if (ObjectUtils.notEquals(resourceLink.getLocalUserId(), localUser.getId())) {
                throw new ForbiddenException(Messages.ERROR_RESOURCE_LINK_FORBIDDEN, resourceLink);
            }
            resourceLinkPersistence.update(resourceLink);

        }
        return new Environment(localUser, resourceLink, launchRequest);
    }

    @Override
    public EnvironmentResponse readEnvironment() {
        Environment environment = EnvironmentService.getEnvironment();
        if (environment == null) {
            throw new NotFoundException(Messages.ERROR_EVIRONMENT_NOT_FOUND);
        }
        return new EnvironmentResponse(environment);
    }

    @Override
    @Transactional(readOnly = true)
    public EnvironmentResponse updateEnvironment(EnvironmentRequest request) {
        Environment environment = EnvironmentService.getEnvironment();
        if (environment == null) {
            throw new NotFoundException(Messages.ERROR_EVIRONMENT_NOT_FOUND);
        }
        if (request.getResourceLinkId() != null) {
            ResourceLink resourceLink = resourceLinkPersistence.get(request.getResourceLinkId(), id -> {
                throw new NotFoundException(Messages.ERROR_RESOURCE_LINK_NOT_FOUND);
            });
            if (ObjectUtils.notEquals(resourceLink.getLocalUserId(), EnvironmentService.getLocalUserId())) {
                throw new ForbiddenException(Messages.ERROR_RESOURCE_LINK_FORBIDDEN);
            }
            environment.setResourceLink(resourceLink);
        } else {
            environment.removeResourceLink();
        }
        return new EnvironmentResponse(environment);
    }
}
