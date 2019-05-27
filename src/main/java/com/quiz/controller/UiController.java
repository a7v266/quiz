package com.quiz.controller;

import com.quiz.service.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/ui")
public class UiController {

    private final RestTemplate restTemplate;

    private static final String PATH_UI_ROOT = "/ui/";
    private static final String PATH_ANY = "/**";

    @Autowired
    private ApplicationProperties applicationProperties;

    public UiController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @PostMapping(value = PATH_ANY)
    public RedirectView authorize(HttpMethod method, HttpServletRequest request, HttpServletResponse response) {
        return new RedirectView(PATH_UI_ROOT);
    }

    @GetMapping(value = PATH_ANY)
    public String getResources(HttpMethod method, HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {
        String scheme = applicationProperties.getUiWebSourceScheme();
        String host = applicationProperties.getUiWebSourceHost();
        int port = applicationProperties.getUiWebSourcePort();
        String uri = request.getRequestURI();
        String query = request.getQueryString();
        URI url = new URI(scheme, null, host, port, uri, query, null);
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @ExceptionHandler(Exception.class)
    public RedirectView handleException(Exception exception) {
        return new RedirectView(PATH_UI_ROOT);
    }
}
