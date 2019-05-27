package com.quiz.service.permission;

import com.quiz.service.ApplicationProperties;
import com.quiz.model.Image;
import com.quiz.service.persistence.ProblemImagePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Validator;

@Service
@Transactional
public class ImagePermissionImpl implements ImagePermission {

    @Autowired
    private Validator standardValidator;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private ProblemImagePersistence problemImagePersistence;


    @Override
    public void checkSaveImage(Image image) {
    }

    @Override
    public void checkDeleteImage(Image image) {
    }

    @Override
    public void checkAccessImage(Image image) {
    }
}
