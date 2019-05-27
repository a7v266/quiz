package com.softaria.quiz.model;

import org.springframework.security.authentication.AbstractAuthenticationToken;

import java.util.Collections;

public class Environment extends AbstractAuthenticationToken {

    private LocalUser localUser;
    private LaunchRequest launchRequest;
    private ResourceLink resourceLink;

    public Environment() {
        super(Collections.emptySet());
    }

    public Environment(LocalUser localUser) {
        super(Collections.emptySet()); //TODO Set Instructor role
        this.localUser = localUser;
    }

    public Environment(LocalUser localUser, ResourceLink resourceLink, LaunchRequest launchRequest) {
        super(Collections.emptySet()); //TODO Set Roles from launchRequest
        this.localUser = localUser;
        this.resourceLink = resourceLink;
        this.launchRequest = launchRequest;
    }

    public final boolean isAuthenticated() {
        return true;
    }

    @Override
    public Object getCredentials() {
        return launchRequest;
    }

    @Override
    public Object getPrincipal() {
        return localUser;
    }

    public String getLisPersonNameFamily() {
        return launchRequest != null ? launchRequest.getLisPersonNameFamily() : null;
    }

    public String getLisPersonNameGiven() {
        return launchRequest != null ? launchRequest.getLisPersonNameGiven() : null;
    }

    public String getPersonRole() {
        // TODO Set on depend launch request
        return PersonRole.INSTRUCTOR;
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        throw new UnsupportedOperationException();
    }

    public LaunchRequest getLaunchRequest() {
        return launchRequest;
    }

    public LocalUser getLocalUser() {
        return localUser;
    }

    public Long getLocalUserId() {
        return localUser != null ? localUser.getId() : null;
    }

    public ResourceLink getResourceLink() {
        return resourceLink;
    }

    public Long getResourceLinkId() {
        return resourceLink != null ? resourceLink.getId() : null;
    }

    public void setResourceLink(ResourceLink resourceLink) {
        this.resourceLink = resourceLink;
    }

    public String getLaunchView() {
        // TODO Set on depend launch request
        return LaunchView.PROBLEMS;
    }

    public void removeResourceLink() {
        resourceLink = null;
    }
}
