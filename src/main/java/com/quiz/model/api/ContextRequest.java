package com.quiz.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quiz.model.Context;
import com.quiz.utils.Format;
import com.quiz.utils.Messages;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class ContextRequest {

    @JsonProperty
    @NotEmpty(message = Messages.ERROR_CONTEXT_ID_EMPTY)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_CONTEXT_ID_MAX_LENGTH)
    private String contextId;

    @JsonProperty
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_CONTEXT_TITLE_MAX_LENGTH)
    private String contextTitle;

    @JsonProperty
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_CONTEXT_LABEL_MAX_LENGTH)
    private String contextLabel;

    @JsonProperty
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_CONTEXT_TYPE_MAX_LENGTH)
    private String contextType;

    public Context createContext() {
        Context context = new Context();
        context.setContextId(contextId);
        return updateContext(context);
    }

    public Context updateContext(Context context) {
        context.setContextTitle(contextTitle);
        context.setContextLabel(contextLabel);
        context.setContextType(contextType);
        return context;
    }
}
