package com.softaria.quiz.service;

import com.softaria.quiz.model.LocalUser;
import com.softaria.quiz.model.RegistrationRequest;
import com.softaria.quiz.model.search.UserSearch;
import com.softaria.quiz.service.permission.UserPermission;
import com.softaria.quiz.service.persistence.UserPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(rollbackFor = Throwable.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserPersistence userPersistence;

    @Autowired
    private UserPermission userPermission;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(RegistrationRequest request) {
        LocalUser user = request.createUser();
        user.setPassword(passwordEncoder.encode(user.getRawPassword()));
        user.setConsumerKey(UUID.randomUUID().toString());
        user.setSharedSecret(UUID.randomUUID().toString());
        userPermission.checkRegisterUser(user);
        userPersistence.merge(user);
    }

    @Override
    public LocalUser findLocalUserByConsumerKey(String consumerKey) {

        return userPersistence.findByConsumerKey(consumerKey);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LocalUser> getUserList(UserSearch search) {
        return userPersistence.list(search);
    }

    @Override
    @Transactional(readOnly = true)
    public Long getUserCount(UserSearch search) {
        return userPersistence.count(search);
    }

    @Override
    @Transactional(readOnly = true)
    public LocalUser getUser(Long id) {
        return userPersistence.get(id);
    }
}
