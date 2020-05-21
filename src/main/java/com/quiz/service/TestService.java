package com.quiz.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;

@Service
public class TestService {

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void test() {
        Arrays.asList(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }
}
