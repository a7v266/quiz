package com.quiz.service.persistence;

import com.quiz.model.LocalUser;

public interface UserPersistence extends BasePersistence<LocalUser, Long> {

    LocalUser findByUsername(String username);

    LocalUser findByConsumerKey(String consumerKey);
}
