package com.quiz.model.api;

import com.quiz.model.ResourceLink;

import java.util.List;

public class ResourceLinkList extends EntityList<ResourceLink> {

    public ResourceLinkList(List<ResourceLink> items, Long totalCount) {
        super(items, totalCount);
    }
}
