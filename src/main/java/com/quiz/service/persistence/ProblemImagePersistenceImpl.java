package com.quiz.service.persistence;

import com.quiz.model.ProblemImage;
import org.springframework.stereotype.Repository;

@Repository
public class ProblemImagePersistenceImpl extends BasePersistenceImpl<ProblemImage, Long> implements ProblemImagePersistence {

    protected ProblemImagePersistenceImpl() {
        super(ProblemImage.class);
    }
}
