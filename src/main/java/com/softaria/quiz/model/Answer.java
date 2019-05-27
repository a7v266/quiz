package com.softaria.quiz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.softaria.quiz.model.json.AnswerStatusDeserializer;
import com.softaria.quiz.model.json.IdentifiableSerializer;

import java.util.Objects;

public class Answer {

    public static final String ANSWER_VALUE = "answerValue";
    public static final String ANSWER_STATUS = "answerStatus";

    @JsonProperty
    private String answerValue;

    @JsonProperty
    @JsonSerialize(using = IdentifiableSerializer.class)
    @JsonDeserialize(using = AnswerStatusDeserializer.class)
    private AnswerStatus answerStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(answerValue, answer.answerValue) &&
                Objects.equals(answerStatus, answer.answerStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerValue, answerStatus);
    }

    public String getAnswerValue() {
        return answerValue;
    }

    public void setAnswerValue(String answerValue) {
        this.answerValue = answerValue;
    }

    public AnswerStatus getAnswerStatus() {
        return answerStatus;
    }

    public void setAnswerStatus(AnswerStatus answerStatus) {
        this.answerStatus = answerStatus;
    }
}
