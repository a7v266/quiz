package com.softaria.quiz.service.persistence;

import com.softaria.quiz.model.LocalUser;
import com.softaria.quiz.model.search.core.Filter;
import com.softaria.quiz.model.search.core.Search;
import org.springframework.stereotype.Repository;

@Repository
public class UserPersistenceImpl extends BasePersistenceImpl<LocalUser, Long> implements UserPersistence {

    public UserPersistenceImpl() {
        super(LocalUser.class);
    }

    @Override
    public LocalUser findByUsername(String username) {
        Search search = new Search();
        search.addFilter(Filter.eq(LocalUser.USERNAME, username));
        return uniqueResult(search);
    }

    @Override
    public LocalUser findByConsumerKey(String consumerKey) {
        Search search = new Search();
        search.addFilter(Filter.eq(LocalUser.CONSUMER_KEY, consumerKey));
        return uniqueResult(search);
    }
}
