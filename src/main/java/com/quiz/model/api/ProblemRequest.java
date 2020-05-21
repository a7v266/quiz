package com.quiz.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quiz.model.AnswerStatus;
import com.quiz.model.Problem;
import com.quiz.utils.Format;
import com.quiz.utils.Messages;
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
        //problem.setExpectedAnswers(expectedAnswers.stream().map(Answer::createAnswer).collect(Collectors.toList()));
        return problem;
    }

    public static class Answer {

        @JsonProperty
        private String answerValue;

        public com.quiz.model.Answer createAnswer() {
            com.quiz.model.Answer answer = new com.quiz.model.Answer();
            answer.setAnswerStatus(AnswerStatus.UNCHECKED);
            answer.setAnswerValue(answerValue);
            return answer;
        }

        public String getAnswerValue() {
            return answerValue;
        }
    }
}
