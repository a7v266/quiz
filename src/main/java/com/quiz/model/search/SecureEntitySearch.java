package com.quiz.model.search;

import com.quiz.model.SecureEntity;
import com.quiz.model.exception.UnauthorizedException;
import com.quiz.model.search.core.Filter;
import com.quiz.service.EnvironmentService;
import com.quiz.utils.Messages;

import java.util.Map;

public class SecureEntitySearch extends RequestSearch {

    public SecureEntitySearch(Map<String, String> parameters) {
        super(parameters);
        Long localUserId = EnvironmentService.getLocalUserId();
        if (localUserId == null) {
            throw new UnauthorizedException(Messages.ERROR_LOCAL_USER_ID_EMPTY);
        }
        addFilter(Filter.eq(SecureEntity.LOCAL_USER_ID, localUserId));
    }
}
