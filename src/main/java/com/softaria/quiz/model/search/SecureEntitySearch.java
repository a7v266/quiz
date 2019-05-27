package com.softaria.quiz.model.search;

import com.softaria.quiz.model.SecureEntity;
import com.softaria.quiz.model.exception.UnauthorizedException;
import com.softaria.quiz.model.search.core.Filter;
import com.softaria.quiz.service.EnvironmentService;
import com.softaria.quiz.utils.Messages;

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
