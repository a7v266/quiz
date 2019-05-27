package com.softaria.quiz.service;

import com.softaria.quiz.model.Problem;
import com.softaria.quiz.model.api.ProblemList;
import com.softaria.quiz.model.api.ProblemRequest;
import com.softaria.quiz.model.search.ProblemSearch;

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
