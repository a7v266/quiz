package com.softaria.quiz.service.permission;

import com.softaria.quiz.model.Context;

import java.util.List;

public interface ContextPermission {

    void checkAccess(List<Context> problems);

    void checkAccess(Context context);

    void checkSave(Context context);

    void checkDelete(Context context);
}
