package com.softaria.quiz.service.persistence;

import com.softaria.quiz.model.ProblemImage;
import org.springframework.stereotype.Repository;

@Repository
public class ProblemImagePersistenceImpl extends BasePersistenceImpl<ProblemImage, Long> implements ProblemImagePersistence {

    protected ProblemImagePersistenceImpl() {
        super(ProblemImage.class);
    }
}
