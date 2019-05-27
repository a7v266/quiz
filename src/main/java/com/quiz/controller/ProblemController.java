package com.quiz.controller;

import com.quiz.service.ProblemService;
import com.quiz.model.Problem;
import com.quiz.model.api.ProblemList;
import com.quiz.model.api.ProblemRequest;
import com.quiz.model.search.ProblemSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ProblemController {

    private static final String PATH_API_PROBLEMS = "/api/problems";
    private static final String PATH_API_PROBLEMS_ID = "/api/problems/{id}";

    @Autowired
    private ProblemService problemService;

    @RequestMapping(value = PATH_API_PROBLEMS, method = RequestMethod.GET)
    public ProblemList getProblems(@RequestParam Map<String, String> parameters) {
        return problemService.getProblems(new ProblemSearch(parameters));
    }

    @RequestMapping(value = PATH_API_PROBLEMS, method = RequestMethod.POST)
    public Problem createProblem(@RequestBody ProblemRequest request) {
        return problemService.createProblem(request);
    }

    @RequestMapping(value = PATH_API_PROBLEMS_ID, method = RequestMethod.GET)
    public Problem readProblem(@PathVariable Long id) {
        return problemService.readProblem(id);
    }

    @RequestMapping(value = PATH_API_PROBLEMS_ID, method = RequestMethod.PUT)
    public Problem updateProblem(@PathVariable Long id, @RequestBody ProblemRequest request) {
        return problemService.updateProblem(id, request);
    }

    @RequestMapping(value = PATH_API_PROBLEMS_ID, method = RequestMethod.DELETE)
    public Problem deleteProblem(@PathVariable Long id) {
        return problemService.deleteProblem(id);
    }
}
