package com.softaria.quiz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.softaria.quiz.utils.DigestUtils;
import com.softaria.quiz.utils.Messages;
import org.hibernate.annotations.Type;
import org.springframework.http.MediaType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@Entity
@Table(name = "image")
public class Image extends SecureEntity {

    public static final String DIGEST = "digest";

    @Column(name = "content_type", updatable = false)
    @JsonProperty
    @NotEmpty(message = Messages.ERROR_IMAGE_TYPE_EMPTY)
    private String contentType;

    @Column(name = "digest", updatable = false)
    @JsonProperty
    @NotEmpty(message = Messages.ERROR_IMAGE_DIGEST_EMPTY)
    private String digest;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "content", updatable = false)
    @Type(type = "org.hibernate.type.BinaryType")
    @NotEmpty(message = Messages.ERROR_IMAGE_CONTENT_EMPTY)
    private byte[] content;

    public static Image create(Long imageId) {
        if (imageId != null) {
            Image image = new Image();
            image.setId(imageId);
            return image;
        }
        return null;
    }

    public void readContent(InputStream inputStream) throws IOException {
        int index, count;
        byte[] buffer = new byte[102400];
        while ((count = inputStream.read(buffer)) > 0) {
            if (content == null) {
                index = 0;
                content = new byte[count];
            } else {
                index = content.length;
                content = Arrays.copyOf(content, content.length + count);
            }
            System.arraycopy(buffer, 0, content, index, count);
        }
        digest = DigestUtils.createSHA256(content);
        contentType = determineContentType();
    }

    private String determineContentType() {
        if (content == null || content.length == 0) {
            return null;
        }
        if (content.length > 2 &&
                content[0] == (byte) 0xFF &&
                content[1] == (byte) 0xD8) {
            return MediaType.IMAGE_JPEG_VALUE;
        }
        if (content.length > 3 &&
                content[0] == (byte) 0x47 &&
                content[1] == (byte) 0x49 &&
                content[2] == (byte) 0x46) {
            return MediaType.IMAGE_GIF_VALUE;
        }
        if (content.length > 8 &&
                content[0] == (byte) 0x89 &&
                content[1] == (byte) 0x50 &&
                content[2] == (byte) 0x4E &&
                content[3] == (byte) 0x47 &&
                content[4] == (byte) 0x0D &&
                content[5] == (byte) 0x0A &&
                content[6] == (byte) 0x1A &&
                content[7] == (byte) 0x0A) {

            return MediaType.IMAGE_PNG_VALUE;
        }
        return null;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
