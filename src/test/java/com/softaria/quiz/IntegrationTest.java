package com.softaria.quiz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softaria.quiz.model.api.ProblemRequest;
import com.softaria.quiz.model.search.RequestSearch;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Application.class)
public class IntegrationTest {

    private static final String PATH_API_PROBLEMS = "/api/problems";
    private static final String PATH_API_PROBLEMS_1 = "/api/problems/1";
    private static final String PATH_API_PROBLEMS_1_TOPIC = "/api/problems/1/topic";
    private static final String PATH_API_PROBLEMS_1_RESOURCE_LINK = "/api/problems/1/resource-link";

    private static final String CREATE_PROBLEM_REQUEST = "requests/create-problem-request.json";
    private static final String UPDATE_PROBLEM_REQUEST = "requests/update-problem-request.json";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void init() throws IOException {
        resourceLoader.loadResources();
        resourceLoader.testResources();
        authenticationService.authenticate();
    }

    @Test
    public void test() throws Exception {
        testCreateProblem();
        testReadProblems();
        testReadProblem();
        testUpdateProblem();
        testDeleteProblem();
    }

    private void testCreateProblem() throws Exception {

        ProblemRequest request = resourceLoader.load(ProblemRequest.class, CREATE_PROBLEM_REQUEST);

        MvcResult result = mvc
                .perform(post(PATH_API_PROBLEMS)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(objectMapper.writeValueAsBytes(request)))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    private void testReadProblems() throws Exception {

        MvcResult result = mvc
                .perform(get(PATH_API_PROBLEMS)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .param(RequestSearch.PAGE_NUMBER, "1")
                        .param(RequestSearch.PAGE_SIZE, "3"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    private void testReadProblem() throws Exception {

        MvcResult result = mvc
                .perform(get(PATH_API_PROBLEMS_1)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    private void testUpdateProblem() throws Exception {

        ProblemRequest request = resourceLoader.load(ProblemRequest.class, UPDATE_PROBLEM_REQUEST);

        MvcResult result = mvc
                .perform(put(PATH_API_PROBLEMS_1)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(objectMapper.writeValueAsBytes(request)))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    private void testDeleteProblem() throws Exception {

        MvcResult result = mvc
                .perform(delete(PATH_API_PROBLEMS_1)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }
}
