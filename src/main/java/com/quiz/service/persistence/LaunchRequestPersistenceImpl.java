package com.quiz.service.persistence;

import com.quiz.model.LaunchRequest;
import org.springframework.stereotype.Repository;

@Repository
public class LaunchRequestPersistenceImpl extends BasePersistenceImpl<LaunchRequest, Long> implements LaunchRequestPersistence {
    public LaunchRequestPersistenceImpl() {
        super(LaunchRequest.class);
    }
}
