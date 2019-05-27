package com.softaria.quiz;

import com.softaria.quiz.model.Environment;
import com.softaria.quiz.model.LocalUser;
import com.softaria.quiz.service.persistence.ResourceLinkPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private ResourceLinkPersistence resourceLinkPersistence;

    @Override
    public void authenticate() {
        Long localUserId = 1L;
        Long resourceLinkId = 11L;
        SecurityContextHolder.getContext().setAuthentication(
                new Environment(LocalUser.create(localUserId), resourceLinkPersistence.get(resourceLinkId), null));
    }
}
