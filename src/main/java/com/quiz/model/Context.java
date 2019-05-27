package com.quiz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quiz.utils.Format;
import com.quiz.utils.Messages;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "context", indexes = {
        @Index(columnList = "context_id", unique = true)
})
public class Context extends SecureEntity {

    public static final String CONTEXT_ID = "contextId";
    public static final String CONTEXT_TITLE = "contextTitle";
    public static final String CONTEXT_LABEL = "contextLabel";
    public static final String CONTEXT_TYPE = "contextType";

    @Column(name = "context_id", nullable = false, updatable = false)
    @JsonProperty
    @NotEmpty(message = Messages.ERROR_CONTEXT_ID_EMPTY)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_CONTEXT_ID_MAX_LENGTH)
    private String contextId;

    @Column(name = "context_title")
    @JsonProperty
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_CONTEXT_TITLE_MAX_LENGTH)
    private String contextTitle;

    @Column(name = "context_label")
    @JsonProperty
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_CONTEXT_LABEL_MAX_LENGTH)
    private String contextLabel;

    @Column(name = "context_type")
    @JsonProperty
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_CONTEXT_TYPE_MAX_LENGTH)
    private String contextType;

    public String getContextId() {
        return contextId;
    }

    public void setContextId(String contextId) {
        this.contextId = contextId;
    }

    public String getContextTitle() {
        return contextTitle;
    }

    public void setContextTitle(String contextTitle) {
        this.contextTitle = contextTitle;
    }

    public String getContextLabel() {
        return contextLabel;
    }

    public void setContextLabel(String contextLabel) {
        this.contextLabel = contextLabel;
    }

    public String getContextType() {
        return contextType;
    }

    public void setContextType(String contextType) {
        this.contextType = contextType;
    }
}
