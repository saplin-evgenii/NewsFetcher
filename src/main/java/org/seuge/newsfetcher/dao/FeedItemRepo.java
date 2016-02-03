package org.seuge.newsfetcher.dao;

import org.seuge.newsfetcher.entities.FeedItem;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * FeedItem repository
 * @author Eugene
 * @since 1.0
 */
public interface FeedItemRepo extends CrudRepository<FeedItem, Long> {

    /**
     * @param title News title
     * @return Collection of news with the given title
     */
    @Query("{'title': ?0}")
    Collection<FeedItem> searchByTitle(String title);
}
