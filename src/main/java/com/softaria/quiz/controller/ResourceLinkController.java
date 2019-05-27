package com.softaria.quiz.controller;

import com.softaria.quiz.model.ResourceLink;
import com.softaria.quiz.model.api.ResourceLinkList;
import com.softaria.quiz.model.api.ResourceLinkRequest;
import com.softaria.quiz.model.search.ResourceLinkSearch;
import com.softaria.quiz.service.ResourceLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class ResourceLinkController {

    private static final String PATH_API_RESOURCE_LINKS = "/api/resource-links";
    private static final String PATH_API_RESOURCE_LINKS_ID = "/api/resource-links/{id}";

    @Autowired
    private ResourceLinkService resourceLinkService;

    @RequestMapping(value = PATH_API_RESOURCE_LINKS, method = RequestMethod.GET)
    public ResourceLinkList getResourceLinks(@RequestParam Map<String, String> parameters) {
        return resourceLinkService.getResourceLinkList(new ResourceLinkSearch(parameters));
    }

    @RequestMapping(value = PATH_API_RESOURCE_LINKS, method = RequestMethod.POST)
    public ResourceLink createResourceLink(@RequestBody @Valid ResourceLinkRequest request) {
        return resourceLinkService.createResourceLink(request);
    }

    @RequestMapping(value = PATH_API_RESOURCE_LINKS_ID, method = RequestMethod.PUT)
    public ResourceLink updateResourceLink(@PathVariable Long id, @RequestBody @Valid ResourceLinkRequest request) {
        return resourceLinkService.updateResourceLink(id, request);
    }

    @RequestMapping(value = PATH_API_RESOURCE_LINKS_ID, method = RequestMethod.DELETE)
    public ResourceLink deleteResourceLink(@PathVariable Long id) {
        return resourceLinkService.deleteResourceLink(id);
    }
}
