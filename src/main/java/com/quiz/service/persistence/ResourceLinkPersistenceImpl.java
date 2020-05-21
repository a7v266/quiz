package com.quiz.service.persistence;

import com.quiz.model.ResourceLink;
import com.quiz.model.search.core.Filter;
import com.quiz.model.search.core.Search;
import org.springframework.stereotype.Repository;

@Repository
public class ResourceLinkPersistenceImpl extends BasePersistenceImpl<ResourceLink, Long> implements ResourceLinkPersistence {

    public ResourceLinkPersistenceImpl() {
        super(ResourceLink.class);
    }

    @Override
    public ResourceLink findByResourceLinkId(String resourceLinkId) {
        Search search = new Search();
        search.addFilter(Filter.eq(ResourceLink.RESOURCE_LINK_ID, resourceLinkId));
        return uniqueResult(search);
    }
}
