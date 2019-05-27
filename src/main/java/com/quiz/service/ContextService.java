package com.quiz.service;

import com.quiz.model.Context;
import com.quiz.model.api.ContextList;
import com.quiz.model.api.ContextRequest;
import com.quiz.model.search.ContextSearch;

public interface ContextService {

    Context getContext(Long id);

    void saveContext(Context context);

    ContextList getContextList(ContextSearch contextSearch);

    Context createContext(ContextRequest request);

    Context readContext(Long contextId);

    Context updateContext(Long contextId, ContextRequest request);

    Context deleteContext(Long contextId);
}
