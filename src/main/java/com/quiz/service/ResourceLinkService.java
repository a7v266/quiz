package com.quiz.service;

import com.quiz.model.ResourceLink;
import com.quiz.model.api.ResourceLinkList;
import com.quiz.model.api.ResourceLinkRequest;
import com.quiz.model.search.ResourceLinkSearch;

public interface ResourceLinkService {

    ResourceLinkList getResourceLinkList(ResourceLinkSearch resourceLinkSearch);

    ResourceLink createResourceLink(ResourceLinkRequest request);

    ResourceLink readResourceLink(Long resourceLinkId);

    ResourceLink updateResourceLink(Long id, ResourceLinkRequest request);

    ResourceLink deleteResourceLink(Long id);

    ResourceLink getResourceLink(Long id);

    void saveResourceLink(ResourceLink resourceLink);
}
