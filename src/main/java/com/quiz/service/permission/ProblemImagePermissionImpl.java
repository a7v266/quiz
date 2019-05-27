package com.quiz.service.permission;

import com.quiz.model.ProblemImage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProblemImagePermissionImpl implements ProblemImagePermission {

    @Override
    public void checkAccessProblemImage(ProblemImage problemImage) {
    }

    @Override
    public void checkSaveProblemImage(ProblemImage problemImage) {
    }

    @Override
    public void checkDeleteProblemImage(ProblemImage problemImage) {
    }
}
