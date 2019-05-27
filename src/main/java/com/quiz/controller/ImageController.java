package com.quiz.controller;

import com.quiz.service.ImageService;
import com.quiz.model.Image;
import com.quiz.model.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ImageController {

    private static final String PATH_API_IMAGES = "/api/images";
    private static final String PATH_API_IMAGES_ID = "/api/images/{id}";
    private static final String IMAGE_FILE = "imageFile";

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = PATH_API_IMAGES, method = RequestMethod.POST)
    public Image uploadImage(@RequestParam(IMAGE_FILE) MultipartFile imageFile) throws IOException {

        return imageService.uploadImage(imageFile.getInputStream());
    }

    @RequestMapping(value = PATH_API_IMAGES_ID, method = RequestMethod.GET)
    public void downloadImage(
            @PathVariable Long id, HttpServletResponse response) throws IOException {

        imageService.downloadImage(id, image -> {
            try {
                response.setContentType(image.getContentType());
                response.getOutputStream().write(image.getContent());
            } catch (IOException exception) {
                throw new ApplicationException(exception);
            }
        });
    }

    @RequestMapping(value = PATH_API_IMAGES_ID, method = RequestMethod.DELETE)
    public Image deleteImage(@PathVariable Long id) {

        return imageService.deleteImage(id);
    }
}
