package com.softaria.quiz.controller;

import com.softaria.quiz.model.Context;
import com.softaria.quiz.model.api.ContextList;
import com.softaria.quiz.model.api.ContextRequest;
import com.softaria.quiz.model.search.ContextSearch;
import com.softaria.quiz.service.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ContextController {

    private static final String PATH_API_CONTEXTS = "/api/contexts";
    private static final String PATH_API_CONTEXTS_ID = "/api/contexts/{id}";

    @Autowired
    private ContextService contextService;

    @RequestMapping(value = PATH_API_CONTEXTS, method = RequestMethod.GET)
    public ContextList getContexts(@RequestParam Map<String, String> parameters) {
        return contextService.getContextList(new ContextSearch(parameters));
    }

    @RequestMapping(value = PATH_API_CONTEXTS, method = RequestMethod.POST)
    public Context createContext(@RequestBody ContextRequest request) {
        return contextService.createContext(request);
    }

    @RequestMapping(value = PATH_API_CONTEXTS_ID, method = RequestMethod.GET)
    public Context readContext(@PathVariable Long id) {
        return contextService.readContext(id);
    }

    @RequestMapping(value = PATH_API_CONTEXTS_ID, method = RequestMethod.PUT)
    public Context updateContext(@PathVariable Long id, @RequestBody ContextRequest request) {
        return contextService.updateContext(id, request);
    }

    @RequestMapping(value = PATH_API_CONTEXTS_ID, method = RequestMethod.DELETE)
    public Context deleteContext(@PathVariable Long id) {
        return contextService.deleteContext(id);
    }
}
