package com.softaria.quiz.service;

import com.softaria.quiz.model.Image;
import com.softaria.quiz.model.exception.BadRequestException;
import com.softaria.quiz.model.exception.NotFoundException;
import com.softaria.quiz.service.permission.ImagePermission;
import com.softaria.quiz.service.persistence.ImagePersistence;
import com.softaria.quiz.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImagePersistence imagePersistence;

    @Autowired
    private ImagePermission imagePermission;

    @Override
    public Image uploadImage(InputStream inputStream) throws IOException {
        Image image = new Image();
        image.readContent(inputStream);
        if (image.getContentType() == null) {
            throw new BadRequestException(Messages.ERROR_IMAGE_UNSUPPORTED_TYPE);
        }
        imagePermission.checkSaveImage(image);
        return imagePersistence.merge(image);
    }

    @Override
    @Transactional(readOnly = true)
    public void downloadImage(Long imageId, Consumer<Image> consumer) {
        Image image = imagePersistence.get(imageId, id -> {
            throw new NotFoundException(Messages.ERROR_IMAGE_NOT_FOUND, id);
        });
        imagePermission.checkAccessImage(image);
        consumer.accept(image);
    }

    @Override
    public Image deleteImage(Long imageId) {
        Image image = imagePersistence.get(imageId, id -> {
            throw new NotFoundException(Messages.ERROR_IMAGE_NOT_FOUND, id);
        });
        imagePermission.checkDeleteImage(image);
        imagePersistence.delete(image);
        return image;
    }
}
