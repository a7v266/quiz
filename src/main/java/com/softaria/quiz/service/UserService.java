package com.softaria.quiz.service;

import com.softaria.quiz.model.LocalUser;
import com.softaria.quiz.model.RegistrationRequest;
import com.softaria.quiz.model.search.UserSearch;

import java.util.List;

public interface UserService {

    void registerUser(RegistrationRequest request);

    LocalUser findLocalUserByConsumerKey(String consumerKey);

    List<LocalUser> getUserList(UserSearch search);

    Long getUserCount(UserSearch search);

    LocalUser getUser(Long id);
}
