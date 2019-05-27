package com.softaria.quiz.model;

import com.softaria.quiz.utils.Messages;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class ResourceLinkIdEntity extends SecureEntity {

    public static final String RESOURCE_LINK_ID = "resourceLinkId";

    @Column(name = "resource_link_id")
    @NotNull(message = Messages.ERROR_RESOURCE_LINK_ID_EMPTY)
    private Long resourceLinkId;

    public Long getResourceLinkId() {
        return resourceLinkId;
    }

    public void setResourceLinkId(Long resourceLinkId) {
        this.resourceLinkId = resourceLinkId;
    }
}
