package com.quiz.service;


import com.quiz.model.Image;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;

public interface ImageService {

    Image uploadImage(InputStream inputStream) throws IOException;

    @Transactional(readOnly = true)
    void downloadImage(Long imageId, Consumer<Image> consumer);

    Image deleteImage(Long imageId);
}
