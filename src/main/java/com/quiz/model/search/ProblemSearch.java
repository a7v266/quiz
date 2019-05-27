package com.quiz.model.search;

import com.quiz.model.Problem;
import com.quiz.model.ResourceLink;
import com.quiz.model.search.core.Filter;

import java.util.Map;

public class ProblemSearch extends SecureEntitySearch {

    public ProblemSearch(Map<String, String> parameters) {
        super(parameters);
    }

    public void setResourceLink(ResourceLink resourceLink) {
        if (resourceLink != null) {
            addFilter(Filter.eq(Problem.RESOURCE_LINK, resourceLink));
        }
    }
}
