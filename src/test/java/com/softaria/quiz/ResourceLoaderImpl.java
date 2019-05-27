package com.softaria.quiz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softaria.quiz.model.Context;
import com.softaria.quiz.model.Problem;
import com.softaria.quiz.model.ResourceLink;
import com.softaria.quiz.service.ContextService;
import com.softaria.quiz.service.ProblemService;
import com.softaria.quiz.service.ResourceLinkService;
import com.softaria.quiz.utils.FileUtils;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class ResourceLoaderImpl implements ResourceLoader {

    private static final String TOPICS = "config/topic.json";
    private static final String CONTEXTS = "config/context.json";
    private static final String RESOURCE_LINKS = "config/resource-link.json";
    private static final String PROBLEMS = "config/problem.json";

    @Autowired
    private ContextService contextService;

    @Autowired
    private ResourceLinkService resourceLinkService;

    @Autowired
    private ProblemService problemService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void loadResources() throws IOException {
        loadContext();
        loadResourceLink();
        loadProblem();
    }

    @Override
    public void testResources() throws IOException {
        testContext();
        testResourceLink();
        testProblem();
    }

    @Override
    public <T> T load(Class<T> clazz, String resource) throws IOException {
        try (BufferedReader reader = new BufferedReader(FileUtils.createReader(resource, StandardCharsets.UTF_8))) {
            return objectMapper.readValue(reader, clazz);
        }
    }

    private void loadContext() throws IOException {
        Context[] source = load(Context[].class, CONTEXTS);
        for (Context context : source) {
            contextService.saveContext(context);
        }
    }

    private void testContext() throws IOException {
        Context[] source = load(Context[].class, CONTEXTS);
        for (Context expectedContext : source) {
            Context context = contextService.getContext(expectedContext.getId());
            Assert.assertNotNull(context);
            Assert.assertEquals(expectedContext.getLocalUserId(), context.getLocalUserId());
            Assert.assertEquals(expectedContext.getContextId(), context.getContextId());
            Assert.assertEquals(expectedContext.getContextTitle(), context.getContextTitle());
            Assert.assertEquals(expectedContext.getContextLabel(), context.getContextLabel());
            Assert.assertEquals(expectedContext.getContextType(), context.getContextType());
        }
    }

    private void loadResourceLink() throws IOException {
        ResourceLink[] source = load(ResourceLink[].class, RESOURCE_LINKS);
        for (ResourceLink resourceLink : source) {
            resourceLinkService.saveResourceLink(resourceLink);
        }
    }

    private void testResourceLink() throws IOException {
        ResourceLink[] source = load(ResourceLink[].class, RESOURCE_LINKS);
        for (ResourceLink expectedResourceLink : source) {
            ResourceLink resourceLink = resourceLinkService.getResourceLink(expectedResourceLink.getId());
            Assert.assertNotNull(resourceLink);
            Assert.assertEquals(expectedResourceLink.getLocalUserId(), resourceLink.getLocalUserId());
            Assert.assertEquals(expectedResourceLink.getContext(), resourceLink.getContext());
            Assert.assertEquals(expectedResourceLink.getResourceLinkId(), resourceLink.getResourceLinkId());
            Assert.assertEquals(expectedResourceLink.getResourceLinkTitle(), resourceLink.getResourceLinkTitle());
            Assert.assertEquals(expectedResourceLink.getResourceLinkDescription(), resourceLink.getResourceLinkDescription());
        }
    }

    private void loadProblem() throws IOException {
        Problem[] source = load(Problem[].class, PROBLEMS);
        for (Problem problem : source) {
            problemService.saveProblem(problem);
        }
    }

    private void testProblem() throws IOException {
        Problem[] source = load(Problem[].class, PROBLEMS);
        for (Problem expectedProblem : source) {
            Problem problem = problemService.getProblem(expectedProblem.getId());
            Assert.assertNotNull(problem);
            Assert.assertEquals(expectedProblem.getResourceLink(), problem.getResourceLink());
            Assert.assertEquals(expectedProblem.getTopicId(), problem.getTopicId());
            Assert.assertEquals(expectedProblem.getProblemDescription(), problem.getProblemDescription());
            Assert.assertThat(expectedProblem.getProblemComplexity(), Matchers.comparesEqualTo(problem.getProblemComplexity()));
            Assert.assertEquals(expectedProblem.getExpectedAnswers(), problem.getExpectedAnswers());
        }
    }
}