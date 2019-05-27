package com.quiz.service.persistence;

import com.quiz.model.Context;
import org.springframework.stereotype.Repository;

@Repository
public class ContextPersistenceImpl extends BasePersistenceImpl<Context, Long> implements ContextPersistence {

    public ContextPersistenceImpl() {
        super(Context.class);
    }

}
