package com.softaria.quiz.service.permission;

import com.softaria.quiz.model.Image;

public interface ImagePermission {
    void checkSaveImage(Image image);

    void checkDeleteImage(Image image);

    void checkAccessImage(Image image);
}
