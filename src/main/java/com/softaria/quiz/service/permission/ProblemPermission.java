package com.softaria.quiz.service.permission;


import com.softaria.quiz.model.Problem;

import java.util.List;

public interface ProblemPermission {

    void checkSave(Problem problem);

    void checkDelete(Problem problem);

    void checkAccess(List<Problem> problemList);

    void checkAccess(Problem problem);
}
