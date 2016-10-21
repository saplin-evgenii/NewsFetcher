package org.seuge.newsfetcher.services;

import org.seuge.newsfetcher.model.entities.RssFeed;

import java.util.List;

/**
 * Rss Feed service
 * @author Eugene
 * @since 1.0
 */
public interface RssFeedService {

    /**
     * Persists the given feed
     * @param newRssFeed feed to persist
     */
    void create(RssFeed newRssFeed);

    /**
     * Returns first entity that has the given original name
     * @param originalName Full name of the entity
     * @return first feed that was found
     */
    RssFeed get(String originalName);

    /**
     * Returns all the feeds
     * @return all feeds found
     */
    List<RssFeed> getAll();

    /**
     * Updates the persisted feed that has the same original name as given feed or
     * persists the given feed if such a persisted feed was not found
     * @param newRssFeed feed with the new properties to persist/update
     */
    void update(RssFeed newRssFeed);

    /**
     * Deletes all the entities that have the given original name
     * @param originalName Full name of the entity
     */
    void delete(String originalName);
}
