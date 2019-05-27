package com.softaria.quiz.service;

import com.softaria.quiz.model.Context;
import com.softaria.quiz.model.api.ContextList;
import com.softaria.quiz.model.api.ContextRequest;
import com.softaria.quiz.model.exception.NotFoundException;
import com.softaria.quiz.model.search.ContextSearch;
import com.softaria.quiz.service.permission.ContextPermission;
import com.softaria.quiz.service.persistence.ContextPersistence;
import com.softaria.quiz.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContextServiceImpl implements ContextService {

    @Autowired
    private ContextPersistence contextPersistence;

    @Autowired
    private ContextPermission contextPermission;

    @Override
    @Transactional(readOnly = true)
    public ContextList getContextList(ContextSearch search) {
        List<Context> list = contextPersistence.list(search);
        Long count = contextPersistence.count(search);
        contextPermission.checkAccess(list);
        return new ContextList(list, count);
    }

    @Override
    public Context createContext(ContextRequest request) {
        Context context = request.createContext();
        contextPermission.checkSave(context);
        return contextPersistence.merge(context);
    }

    @Override
    @Transactional(readOnly = true)
    public Context readContext(Long contextId) {
        Context context = contextPersistence.get(contextId, id -> {
            throw new NotFoundException(Messages.ERROR_CONTEXT_NOT_FOUND, id);
        });
        contextPermission.checkAccess(context);
        return context;
    }

    @Override
    public Context updateContext(Long contextId, ContextRequest request) {
        Context context = contextPersistence.get(contextId, id -> {
            throw new NotFoundException(Messages.ERROR_CONTEXT_NOT_FOUND, id);
        });
        request.updateContext(context);
        contextPermission.checkSave(context);
        return contextPersistence.merge(context);
    }

    @Override
    public Context deleteContext(Long contextId) {
        Context context = contextPersistence.get(contextId, id -> {
            throw new NotFoundException(Messages.ERROR_CONTEXT_NOT_FOUND, id);
        });
        contextPermission.checkDelete(context);
        return contextPersistence.delete(context);
    }

    @Override
    @Transactional(readOnly = true)
    public Context getContext(Long id) {
        return contextPersistence.get(id);
    }

    @Override
    public void saveContext(Context context) {
        contextPersistence.save(context);
    }
}
