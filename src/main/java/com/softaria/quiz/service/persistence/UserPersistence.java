package com.softaria.quiz.service.persistence;

import com.softaria.quiz.model.LocalUser;

public interface UserPersistence extends BasePersistence<LocalUser, Long> {

    LocalUser findByUsername(String username);

    LocalUser findByConsumerKey(String consumerKey);
}
