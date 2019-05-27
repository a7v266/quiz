package com.quiz.service.persistence;

import com.quiz.model.ResourceLink;
import org.springframework.stereotype.Repository;

@Repository
public class ResourceLinkPersistenceImpl extends BasePersistenceImpl<ResourceLink, Long> implements ResourceLinkPersistence {

    public ResourceLinkPersistenceImpl() {
        super(ResourceLink.class);
    }

}
