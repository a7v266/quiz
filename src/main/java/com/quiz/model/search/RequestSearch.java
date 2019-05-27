package com.quiz.model.search;

import com.quiz.model.search.core.Search;
import com.quiz.utils.NumberUtils;

import java.util.Map;

public class RequestSearch extends Search {

    public static final String PAGE_NUMBER = "pageNumber";
    public static final String PAGE_SIZE = "pageSize";

    private Map<String, String> parameters;

    public RequestSearch(Map<String, String> parameters) {
        this.parameters = parameters;
        setPagination(getPageNumber(), getPageSize());
    }

    public Object get(String key) {
        return parameters.get(key);
    }

    public Integer getPageNumber() {
        return NumberUtils.getInteger(get(PAGE_NUMBER));
    }

    public Integer getPageSize() {
        return NumberUtils.getInteger(get(PAGE_SIZE));
    }
}
