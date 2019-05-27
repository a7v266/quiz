package com.softaria.quiz.service.security;

import com.softaria.quiz.model.LaunchRequest;
import com.softaria.quiz.model.LocalUser;
import com.softaria.quiz.model.exception.ConsumerKeyEmptyException;
import com.softaria.quiz.model.exception.ConsumerKeyNotFoundException;
import com.softaria.quiz.service.EnvironmentService;
import com.softaria.quiz.service.persistence.ContextPersistence;
import com.softaria.quiz.service.persistence.LaunchRequestPersistence;
import com.softaria.quiz.service.persistence.ResourceLinkPersistence;
import com.softaria.quiz.service.persistence.UserPersistence;
import com.softaria.quiz.utils.Format;
import com.softaria.quiz.utils.StringUtils;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthException;
import net.oauth.OAuthMessage;
import net.oauth.signature.OAuthSignatureMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
@Transactional
public class LtiAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserPersistence userPersistence;

    @Autowired
    private LaunchRequestPersistence launchRequestPersistence;

    @Autowired
    private EnvironmentService environmentService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (!supports(authentication.getClass())) {
            return null;
        }
        LtiAuthenticationToken token = (LtiAuthenticationToken) authentication;
        try {

            OAuthMessage authMessage = token.getAuthMessage();
            String consumerKey = authMessage.getConsumerKey();
            if (StringUtils.isEmpty(consumerKey)) {
                throw new ConsumerKeyEmptyException();
            }

            LocalUser localUser = userPersistence.findByConsumerKey(consumerKey);
            if (localUser == null) {
                throw new ConsumerKeyNotFoundException(consumerKey);
            }

            OAuthConsumer consumer = new OAuthConsumer(Format.EMPTY_STRING,
                    consumerKey, localUser.getSharedSecret(), null);

            OAuthSignatureMethod.newSigner(authMessage, new OAuthAccessor(consumer))
                    .validate(authMessage);

            LaunchRequest launchRequest = launchRequestPersistence.merge(token.getLaunchRequest());

            return environmentService.createEnvironment(localUser, launchRequest);

        } catch (IOException | OAuthException | URISyntaxException exception) {

            throw new BadCredentialsException(exception.getMessage(), exception);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(LtiAuthenticationToken.class);
    }
}
