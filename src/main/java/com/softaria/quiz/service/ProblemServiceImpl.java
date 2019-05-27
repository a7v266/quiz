package com.softaria.quiz.service;

import com.softaria.quiz.model.Problem;
import com.softaria.quiz.model.ResourceLink;
import com.softaria.quiz.model.api.ProblemList;
import com.softaria.quiz.model.api.ProblemRequest;
import com.softaria.quiz.model.exception.ConflictException;
import com.softaria.quiz.model.exception.NotFoundException;
import com.softaria.quiz.model.search.ProblemSearch;
import com.softaria.quiz.service.permission.ProblemPermission;
import com.softaria.quiz.service.persistence.ProblemPersistence;
import com.softaria.quiz.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemPersistence problemPersistence;

    @Autowired
    private ProblemPermission problemPermission;

    @Override
    @Transactional(readOnly = true)
    public ProblemList getProblems(ProblemSearch search) {
        ResourceLink resourceLink = EnvironmentService.getResourceLink();
        if (resourceLink == null) {
            throw new ConflictException(Messages.ERROR_RESOURCE_LINK_EMPTY);
        }
        List<Problem> problemList = problemPersistence.list(search);
        problemPermission.checkAccess(problemList);
        Long problemCount = problemPersistence.count(search);
        return new ProblemList(problemList, problemCount);
    }

    @Override
    public Problem createProblem(ProblemRequest request) {
        Problem problem = request.createProblem();
        problem.setResourceLink(EnvironmentService.getResourceLink());
        problemPermission.checkSave(problem);
        return problemPersistence.merge(problem);
    }

    @Override
    @Transactional(readOnly = true)
    public Problem readProblem(Long id) {
        Problem problem = problemPersistence.get(id, problemId -> {
            throw new NotFoundException(Messages.ERROR_PROBLEM_NOT_FOUND, problemId);
        });
        problemPermission.checkAccess(problem);
        return problem;
    }

    @Override
    public Problem updateProblem(Long id, ProblemRequest request) {
        Problem problem = problemPersistence.get(id, problemId -> {
            throw new NotFoundException(Messages.ERROR_PROBLEM_NOT_FOUND, problemId);
        });
        request.updateProblem(problem);
        problemPermission.checkSave(problem);
        return problemPersistence.merge(problem);
    }

    @Override
    public Problem deleteProblem(Long id) {
        Problem problem = problemPersistence.get(id, problemId -> {
            throw new NotFoundException(Messages.ERROR_PROBLEM_NOT_FOUND, problemId);
        });
        problemPermission.checkDelete(problem);
        return problemPersistence.delete(problem);
    }

    @Override
    @Transactional(readOnly = true)
    public Problem getProblem(Long id) {
        return problemPersistence.get(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Problem> getProblemList(ProblemSearch search) {
        return problemPersistence.list(search);
    }

    @Override
    @Transactional(readOnly = true)
    public Long getProblemCount(ProblemSearch search) {
        return problemPersistence.count(search);
    }

    @Override
    public void saveProblem(Problem problem) {
        problemPersistence.save(problem);
    }
}
