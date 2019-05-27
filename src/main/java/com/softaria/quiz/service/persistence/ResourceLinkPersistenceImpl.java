package com.softaria.quiz.service.persistence;

import com.softaria.quiz.model.ResourceLink;
import org.springframework.stereotype.Repository;

@Repository
public class ResourceLinkPersistenceImpl extends BasePersistenceImpl<ResourceLink, Long> implements ResourceLinkPersistence {

    public ResourceLinkPersistenceImpl() {
        super(ResourceLink.class);
    }

}
