package com.quiz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.quiz.model.validation.AnswerListConstraint;
import com.quiz.utils.Format;
import com.quiz.utils.Messages;
import com.quiz.model.json.BaseEntitySerializer;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "problem")
public class Problem extends SecureEntity {

    public static final String RESOURCE_LINK = "resourceLink";
    public static final String TOPIC_ID = "topicId";
    public static final String PROBLEM_DESCRIPTION = "problemDescription";
    public static final String PROBLEM_COMPLEXITY = "problemComplexity";
    public static final String EXPECTED_ANSWERS = "expectedAnswers";

    @ManyToOne
    @JoinColumn(name = "resource_link_id", updatable = false)
    @JsonProperty
    @JsonSerialize(using = BaseEntitySerializer.class)
    @NotNull(message = Messages.ERROR_RESOURCE_LINK_EMPTY)
    private ResourceLink resourceLink;

    @Column(name = "topic_id")
    @JsonProperty
    @NotEmpty(message = Messages.ERROR_TOPIC_ID_EMPTY)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_TOPIC_ID_MAX_LENGTH)
    private String topicId;

    @Lob
    @Column(name = "problem_description", nullable = false)
    @JsonProperty
    @NotEmpty(message = Messages.ERROR_PROBLEM_DESCRIPTION_EMPTY)
    private String problemDescription;

    @Column(name = "problem_complexity")
    @JsonProperty
    @NotNull(message = Messages.ERROR_PROBLEM_COMPLEXITY_EMPTY)
    private BigDecimal problemComplexity;
/*
    @Column(name = "expected_answers", nullable = false)
    @Type(type = "AnswerListType")
    @JsonProperty
    @AnswerListConstraint
    @NotEmpty(message = Messages.ERROR_ANSWER_LIST_EMPTY)
    private List<Answer> expectedAnswers;
*/
    public ResourceLink getResourceLink() {
        return resourceLink;
    }

    public void setResourceLink(ResourceLink resourceLink) {
        this.resourceLink = resourceLink;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public BigDecimal getProblemComplexity() {
        return problemComplexity;
    }

    public void setProblemComplexity(BigDecimal problemComplexity) {
        this.problemComplexity = problemComplexity;
    }
/*
    public List<Answer> getExpectedAnswers() {
        return expectedAnswers;
    }

    public void setExpectedAnswers(List<Answer> expectedAnswers) {
        this.expectedAnswers = expectedAnswers;
      }
*/
}
