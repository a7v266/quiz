package com.quiz.service.permission;

import com.quiz.model.ResourceLink;

public interface ResourceLinkPermission extends BasePermission {

    void checkSave(ResourceLink resourceLink);

    void checkDelete(ResourceLink resourceLink);
}
