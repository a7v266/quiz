package com.softaria.quiz.service.permission;

import com.softaria.quiz.model.ResourceLink;

public interface ResourceLinkPermission extends BasePermission {

    void checkSave(ResourceLink resourceLink);

    void checkDelete(ResourceLink resourceLink);
}
