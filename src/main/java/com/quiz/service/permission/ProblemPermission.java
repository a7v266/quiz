package com.quiz.service.permission;


import com.quiz.model.Problem;

import java.util.List;

public interface ProblemPermission {

    void checkSave(Problem problem);

    void checkDelete(Problem problem);

    void checkAccess(List<Problem> problemList);

    void checkAccess(Problem problem);
}
