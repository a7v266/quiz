package com.quiz.service.permission;

import com.quiz.model.ProblemImage;

public interface ProblemImagePermission {

    void checkAccessProblemImage(ProblemImage problemImage);

    void checkSaveProblemImage(ProblemImage problemImage);

    void checkDeleteProblemImage(ProblemImage problemImage);
}
