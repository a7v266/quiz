package com.quiz.service;

import com.quiz.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.INTERFACES)
public class RequestParametersImpl implements RequestParameters {

    private static final int DEFAULT_SERVER_PORT = 80;
    private static final String FULL_TEMPLATE = "%s://%s:%d/ui/";
    private static final String SHORT_TEMPLATE = "%s://%s/ui/";

    @Autowired
    private HttpServletRequest request;

    @Override
    public String getRequestUrl() {
        if (request.getServerPort() == DEFAULT_SERVER_PORT) {
            return StringUtils.format(SHORT_TEMPLATE, request.getScheme(), request.getServerName());
        }
        return StringUtils.format(FULL_TEMPLATE, request.getScheme(), request.getServerName(), request.getServerPort());
    }
}
