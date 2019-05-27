package com.softaria.quiz.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.softaria.quiz.model.AnswerStatus;
import com.softaria.quiz.model.Problem;
import com.softaria.quiz.utils.Format;
import com.softaria.quiz.utils.Messages;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemRequest {

    @JsonProperty
    @NotEmpty(message = Messages.ERROR_TOPIC_ID_EMPTY)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_TOPIC_ID_MAX_LENGTH)
    private String topicId;

    @JsonProperty
    @NotEmpty(message = Messages.ERROR_PROBLEM_DESCRIPTION_EMPTY)
    private String problemDescription;

    @JsonProperty
    @NotNull(message = Messages.ERROR_PROBLEM_COMPLEXITY_EMPTY)
    private BigDecimal problemComplexity;

    @JsonProperty
    @NotEmpty(message = Messages.ERROR_ANSWER_LIST_EMPTY)
    private List<Answer> expectedAnswers;


    public Problem createProblem() {
        return updateProblem(new Problem());
    }

    public Problem updateProblem(Problem problem) {
        problem.setTopicId(topicId);
        problem.setProblemDescription(problemDescription);
        problem.setProblemComplexity(problemComplexity);
        problem.setExpectedAnswers(expectedAnswers.stream().map(Answer::createAnswer).collect(Collectors.toList()));
        return problem;
    }

    public static class Answer {

        @JsonProperty
        private String answerValue;

        public com.softaria.quiz.model.Answer createAnswer() {
            com.softaria.quiz.model.Answer answer = new com.softaria.quiz.model.Answer();
            answer.setAnswerStatus(AnswerStatus.UNCHECKED);
            answer.setAnswerValue(answerValue);
            return answer;
        }

        public String getAnswerValue() {
            return answerValue;
        }
    }
}
