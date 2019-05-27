package com.quiz.service.permission;

import com.quiz.model.Context;

import java.util.List;

public interface ContextPermission {

    void checkAccess(List<Context> problems);

    void checkAccess(Context context);

    void checkSave(Context context);

    void checkDelete(Context context);
}
