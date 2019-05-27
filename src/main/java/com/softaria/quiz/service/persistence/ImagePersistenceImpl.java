package com.softaria.quiz.service.persistence;

import com.softaria.quiz.model.Image;
import org.springframework.stereotype.Repository;

@Repository
public class ImagePersistenceImpl extends BasePersistenceImpl<Image, Long> implements ImagePersistence {

    public ImagePersistenceImpl() {
        super(Image.class);
    }
}
