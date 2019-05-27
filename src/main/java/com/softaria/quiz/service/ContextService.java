package com.softaria.quiz.service;

import com.softaria.quiz.model.Context;
import com.softaria.quiz.model.api.ContextList;
import com.softaria.quiz.model.api.ContextRequest;
import com.softaria.quiz.model.search.ContextSearch;

public interface ContextService {

    Context getContext(Long id);

    void saveContext(Context context);

    ContextList getContextList(ContextSearch contextSearch);

    Context createContext(ContextRequest request);

    Context readContext(Long contextId);

    Context updateContext(Long contextId, ContextRequest request);

    Context deleteContext(Long contextId);
}
