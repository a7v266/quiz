package com.quiz.service.security;

import com.quiz.service.EnvironmentService;
import com.quiz.service.persistence.UserPersistence;
import com.quiz.model.LocalUser;
import com.quiz.model.exception.InvalidAuthenticationException;
import com.quiz.utils.Messages;
import com.quiz.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UsernameAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private EnvironmentService environmentService;

    @Autowired
    private UserPersistence userPersistence;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (!supports(authentication.getClass())) {
            return null;
        }
        String username = StringUtils.valueOf(authentication.getPrincipal());
        if (StringUtils.isEmpty(username)) {
            throw new InvalidAuthenticationException(Messages.ERROR_INVALID_AUTHENTICATION);
        }
        LocalUser user = userPersistence.findByUsername(username);
        if (user == null) {
            throw new InvalidAuthenticationException(Messages.ERROR_INVALID_AUTHENTICATION);
        }
        if (authentication.getCredentials() == null) {
            throw new InvalidAuthenticationException(Messages.ERROR_INVALID_AUTHENTICATION);
        }
        String presentedPassword = authentication.getCredentials().toString();
        if (!passwordEncoder.matches(presentedPassword, user.getPassword())) {
            throw new InvalidAuthenticationException(Messages.ERROR_INVALID_AUTHENTICATION);
        }
        return environmentService.createEnvironment(user);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
