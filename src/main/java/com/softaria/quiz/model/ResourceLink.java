package com.softaria.quiz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.softaria.quiz.model.json.BaseEntitySerializer;
import com.softaria.quiz.utils.Format;
import com.softaria.quiz.utils.Messages;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "resource_link", indexes = {
        @Index(columnList = "resource_link_id", unique = true)
})
public class ResourceLink extends SecureEntity {

    public static final String CONTEXT = "context";
    public static final String RESOURCE_LINK_ID = "resourceLinkId";
    public static final String RESOURCE_LINK_TITLE = "resourceLinkTitle";
    public static final String RESOURCE_LINK_DESCRIPTION = "resourceLinkDescription";

    @ManyToOne
    @NotNull(message = Messages.ERROR_CONTEXT_EMPTY)
    @JsonProperty
    @JsonSerialize(using = BaseEntitySerializer.class)
    private Context context;

    @Column(name = "resource_link_id", nullable = false)
    @NotEmpty(message = Messages.ERROR_RESOURCE_LINK_ID_EMPTY)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_RESOURCE_LINK_ID_MAX_LENGTH)
    @JsonProperty
    private String resourceLinkId;

    @Column(name = "resource_link_title")
    @JsonProperty
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_RESOURCE_LINK_TITLE_MAX_LENGTH)
    private String resourceLinkTitle;

    @Column(name = "resource_link_description")
    @JsonProperty
    private String resourceLinkDescription;

    public Long getContextId() {
        return context.getId();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getResourceLinkId() {
        return resourceLinkId;
    }

    public void setResourceLinkId(String resourceLinkId) {
        this.resourceLinkId = resourceLinkId;
    }

    public String getResourceLinkTitle() {
        return resourceLinkTitle;
    }

    public void setResourceLinkTitle(String resourceLinkTitle) {
        this.resourceLinkTitle = resourceLinkTitle;
    }

    public String getResourceLinkDescription() {
        return resourceLinkDescription;
    }

    public void setResourceLinkDescription(String resourceLinkDescription) {
        this.resourceLinkDescription = resourceLinkDescription;
    }
}
