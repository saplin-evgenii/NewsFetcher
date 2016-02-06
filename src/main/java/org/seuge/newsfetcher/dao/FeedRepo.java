package org.seuge.newsfetcher.dao;

import org.bson.types.ObjectId;
import org.seuge.newsfetcher.entities.Feed;
import org.seuge.newsfetcher.entities.RssFeed;
import org.springframework.data.repository.CrudRepository;

/**
 * Feed repository
 * @author Eugene
 * @since 1.0
 */
public interface FeedRepo<FeedType extends Feed> extends CrudRepository<FeedType, ObjectId> {

    /**
     * Returns first entity that has the given original name
     * @param originalName Full name of the entity
     * @return first feed that was found
     */
    RssFeed findByOriginalName(String originalName);

    /**
     * Deletes all the entities that have the given original name
     * @param originalName Full name of the entity
     */
    void deleteByOriginalName(String originalName);
}
