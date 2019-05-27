package com.quiz.service;

import com.quiz.model.Problem;
import com.quiz.model.api.ProblemList;
import com.quiz.model.api.ProblemRequest;
import com.quiz.model.search.ProblemSearch;

import java.util.List;

public interface ProblemService {

    Problem createProblem(ProblemRequest request);

    Problem readProblem(Long id);

    ProblemList getProblems(ProblemSearch search);

    Problem updateProblem(Long id, ProblemRequest request);

    Problem deleteProblem(Long id);

    Problem getProblem(Long id);

    List<Problem> getProblemList(ProblemSearch search);

    Long getProblemCount(ProblemSearch search);

    void saveProblem(Problem problem);
}
