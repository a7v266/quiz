package com.softaria.quiz.service.security;

import com.softaria.quiz.model.LaunchRequest;
import net.oauth.OAuthMessage;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class LtiAuthenticationToken extends AbstractAuthenticationToken {

    private LaunchRequest launchRequest;
    private OAuthMessage authMessage;

    public LtiAuthenticationToken(LaunchRequest launchRequest, OAuthMessage authMessage) {
        super(null);
        this.launchRequest = launchRequest;
        this.authMessage = authMessage;
    }

    public final boolean isAuthenticated() {
        return false;
    }

    @Override
    public Object getCredentials() {
        return authMessage;
    }

    @Override
    public Object getPrincipal() {
        return launchRequest;
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        throw new UnsupportedOperationException();
    }

    public LaunchRequest getLaunchRequest() {
        return launchRequest;
    }

    public OAuthMessage getAuthMessage() {
        return authMessage;
    }
}
