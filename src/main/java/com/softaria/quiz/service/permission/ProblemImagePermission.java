package com.softaria.quiz.service.permission;

import com.softaria.quiz.model.ProblemImage;

public interface ProblemImagePermission {

    void checkAccessProblemImage(ProblemImage problemImage);

    void checkSaveProblemImage(ProblemImage problemImage);

    void checkDeleteProblemImage(ProblemImage problemImage);
}
