package com.quiz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quiz.utils.Messages;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "problem_image", indexes = @Index(columnList = "problem_id, image_id"))
public class ProblemImage extends SecureEntity {

    public static final String PROBLEM = "problem";
    public static final String IMAGE = "image";

    @ManyToOne
    @JoinColumn(name = "problem_id")
    @NotNull(message = Messages.ERROR_PROBLEM_EMPTY)
    @JsonProperty
    private Problem problem;

    @ManyToOne
    @JoinColumn(name = "image_id")
    @NotNull(message = Messages.ERROR_IMAGE_EMPTY)
    @JsonProperty
    private Image image;


    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
