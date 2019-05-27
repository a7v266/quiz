package com.softaria.quiz.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.softaria.quiz.model.ResourceLink;
import com.softaria.quiz.utils.Format;
import com.softaria.quiz.utils.Messages;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ResourceLinkRequest implements Serializable {

    @JsonProperty
    @NotNull(message = Messages.ERROR_CONTEXT_ID_EMPTY)
    private Long contextId;

    @JsonProperty
    @NotEmpty(message = Messages.ERROR_RESOURCE_LINK_ID_EMPTY)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_RESOURCE_LINK_ID_MAX_LENGTH)
    private String resourceLinkId;

    @JsonProperty
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_RESOURCE_LINK_TITLE_MAX_LENGTH)
    private String resourceLinkTitle;

    @JsonProperty
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_RESOURCE_LINK_DESCRIPTION_MAX_LENGTH)
    private String resourceLinkDescription;

    public Long getContextId() {
        return contextId;
    }

    public ResourceLink createResourceLink() {
        return updateResourceLink(new ResourceLink());
    }

    public ResourceLink updateResourceLink(ResourceLink resourceLink) {
        resourceLink.setResourceLinkId(resourceLinkId);
        resourceLink.setResourceLinkTitle(resourceLinkTitle);
        resourceLink.setResourceLinkDescription(resourceLinkDescription);
        return resourceLink;
    }
}
