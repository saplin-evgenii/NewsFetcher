package org.seuge.newsfetcher.services;

import org.seuge.newsfetcher.entities.RssFeed;

import java.util.List;

/**
 * Rss Feed service
 * @author Eugene
 * @since 1.0
 */
public interface RssFeedService {

    List<RssFeed> getAll();

}
