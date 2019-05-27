package com.quiz.service;

import com.quiz.model.LocalUser;
import com.quiz.model.RegistrationRequest;
import com.quiz.model.search.UserSearch;

import java.util.List;

public interface UserService {

    void registerUser(RegistrationRequest request);

    LocalUser findLocalUserByConsumerKey(String consumerKey);

    List<LocalUser> getUserList(UserSearch search);

    Long getUserCount(UserSearch search);

    LocalUser getUser(Long id);
}
