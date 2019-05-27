package com.quiz.utils;

import javax.servlet.http.HttpServletRequest;

public class HttpUtils {

    public static String getBaseURL(HttpServletRequest request) {
        StringBuilder url = new StringBuilder();
        String scheme = request.getScheme();
        int port = request.getServerPort();
        if (port < 0) {
            port = 80;
        }
        url.append(scheme);
        url.append("://");
        url.append(request.getServerName());
        if ((scheme.equals("http") && (port != 80))
                || (scheme.equals("https") && (port != 443))) {
            url.append(':');
            url.append(port);
        }
        return url.toString();
    }
}
