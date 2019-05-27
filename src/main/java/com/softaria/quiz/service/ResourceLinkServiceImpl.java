package com.softaria.quiz.service;

import com.softaria.quiz.model.ResourceLink;
import com.softaria.quiz.model.api.ResourceLinkList;
import com.softaria.quiz.model.api.ResourceLinkRequest;
import com.softaria.quiz.model.exception.NotFoundException;
import com.softaria.quiz.model.search.ResourceLinkSearch;
import com.softaria.quiz.service.permission.ResourceLinkPermission;
import com.softaria.quiz.service.persistence.ContextPersistence;
import com.softaria.quiz.service.persistence.ResourceLinkPersistence;
import com.softaria.quiz.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ResourceLinkServiceImpl implements ResourceLinkService {

    @Autowired
    private ResourceLinkPersistence resourceLinkPersistence;

    @Autowired
    private ResourceLinkPermission resourceLinkPermission;

    @Autowired
    private ContextPersistence contextPersistence;

    @Override
    @Transactional(readOnly = true)
    public ResourceLinkList getResourceLinkList(ResourceLinkSearch search) {
        List<ResourceLink> list = resourceLinkPersistence.list(search);
        Long count = resourceLinkPersistence.count(search);
        resourceLinkPermission.checkAccess(list);
        return new ResourceLinkList(list, count);
    }

    @Override
    public ResourceLink createResourceLink(ResourceLinkRequest request) {
        ResourceLink resourceLink = request.createResourceLink();
        resourceLink.setContext(contextPersistence.get(request.getContextId(), id -> {
            throw new NotFoundException(Messages.ERROR_CONTEXT_NOT_FOUND);
        }));
        resourceLinkPermission.checkSave(resourceLink);
        return resourceLinkPersistence.merge(resourceLink);
    }

    @Override
    public ResourceLink readResourceLink(Long resourceLinkId) {
        ResourceLink resourceLink = resourceLinkPersistence.get(resourceLinkId, id -> {
            throw new NotFoundException(Messages.ERROR_RESOURCE_LINK_NOT_FOUND, id);
        });
        resourceLinkPermission.checkAccess(resourceLink);
        return resourceLink;
    }

    @Override
    public ResourceLink updateResourceLink(Long resourceLinkId, ResourceLinkRequest request) {
        ResourceLink resourceLink = resourceLinkPersistence.get(resourceLinkId, id -> {
            throw new NotFoundException(Messages.ERROR_RESOURCE_LINK_NOT_FOUND, id);
        });
        request.updateResourceLink(resourceLink);
        resourceLink.setContext(contextPersistence.get(request.getContextId(), id -> {
            throw new NotFoundException(Messages.ERROR_CONTEXT_NOT_FOUND, id);
        }));
        resourceLinkPermission.checkSave(resourceLink);
        return resourceLinkPersistence.merge(resourceLink);
    }

    @Override
    public ResourceLink deleteResourceLink(Long resourceLinkId) {
        ResourceLink resourceLink = resourceLinkPersistence.get(resourceLinkId, id -> {
            throw new NotFoundException(Messages.ERROR_RESOURCE_LINK_NOT_FOUND, id);
        });
        resourceLinkPermission.checkDelete(resourceLink);
        return resourceLinkPersistence.delete(resourceLink);
    }

    @Override
    @Transactional(readOnly = true)
    public ResourceLink getResourceLink(Long id) {
        return resourceLinkPersistence.get(id);
    }

    @Override
    public void saveResourceLink(ResourceLink resourceLink) {
        resourceLink.setContext(contextPersistence.load(resourceLink.getContextId()));
        resourceLinkPersistence.save(resourceLink);
    }
}
