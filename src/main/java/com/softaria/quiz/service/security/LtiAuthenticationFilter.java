package com.softaria.quiz.service.security;

import com.softaria.quiz.model.LaunchRequest;
import com.softaria.quiz.model.LocalUser;
import com.softaria.quiz.model.exception.ConsumerKeyEmptyException;
import com.softaria.quiz.model.exception.ConsumerKeyNotFoundException;
import com.softaria.quiz.service.ApplicationProperties;
import com.softaria.quiz.service.EnvironmentService;
import com.softaria.quiz.service.LaunchRequestBuilder;
import com.softaria.quiz.service.UserService;
import com.softaria.quiz.utils.Format;
import com.softaria.quiz.utils.StringUtils;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthException;
import net.oauth.OAuthMessage;
import net.oauth.server.OAuthServlet;
import net.oauth.signature.OAuthSignatureMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;

public class LtiAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private UserService userService;

    private EnvironmentService environmentService;

    private ApplicationProperties applicationProperties;

    public LtiAuthenticationFilter(UserService userService,
                                   EnvironmentService environmentService,
                                   ApplicationProperties applicationProperties,
                                   AuthenticationManager authenticationManager,
                                   LtiAuthenticationSuccessHandler successHandler) {

        super(applicationProperties.getLaunchRequestMatcher());

        setAuthenticationManager(authenticationManager);
        setAuthenticationSuccessHandler(successHandler);

        this.userService = userService;
        this.environmentService = environmentService;
        this.applicationProperties = applicationProperties;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        try {

            LaunchRequest launchRequest = LaunchRequestBuilder.createLaunchRequest(request);

            OAuthMessage authMessage = OAuthServlet.getMessage(request, applicationProperties.getUiLaunchUrl());

            String consumerKey = authMessage.getConsumerKey();
            if (StringUtils.isEmpty(consumerKey)) {
                throw new ConsumerKeyEmptyException();
            }

            LocalUser localUser = userService.findLocalUserByConsumerKey(consumerKey);
            if (localUser == null) {
                throw new ConsumerKeyNotFoundException(consumerKey);
            }

            OAuthConsumer consumer = new OAuthConsumer(Format.EMPTY_STRING,
                    consumerKey, localUser.getSharedSecret(), null);

            OAuthSignatureMethod.newSigner(authMessage, new OAuthAccessor(consumer))
                    .validate(authMessage);

            return environmentService.createEnvironment(localUser, launchRequest);

        } catch (IOException | OAuthException | URISyntaxException exception) {

            throw new BadCredentialsException(exception.getMessage(), exception);
        }
    }
}