package com.quiz.service.persistence;

import com.quiz.model.Problem;
import org.springframework.stereotype.Repository;

@Repository
public class ProblemPersistenceImpl extends BasePersistenceImpl<Problem, Long> implements ProblemPersistence {

    protected ProblemPersistenceImpl() {
        super(Problem.class);
    }
}
