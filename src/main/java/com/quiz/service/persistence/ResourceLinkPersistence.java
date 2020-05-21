package com.quiz.service.persistence;

import com.quiz.model.LaunchRequest;
import com.quiz.model.ResourceLink;

public interface ResourceLinkPersistence extends BasePersistence<ResourceLink, Long> {

    ResourceLink findByResourceLinkId(String resourceLinkId);
}
