package org.seuge.newsfetcher.dao;

import org.seuge.newsfetcher.entities.Feed;
import org.springframework.data.repository.CrudRepository;

/**
 * Feed repository
 * @author Eugene
 * @since 1.0
 */
public interface FeedRepo<FeedType extends Feed> extends CrudRepository<FeedType, Long> {
}
