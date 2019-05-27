package com.softaria.quiz.service.persistence;

import com.softaria.quiz.model.Context;
import org.springframework.stereotype.Repository;

@Repository
public class ContextPersistenceImpl extends BasePersistenceImpl<Context, Long> implements ContextPersistence {

    public ContextPersistenceImpl() {
        super(Context.class);
    }

}
