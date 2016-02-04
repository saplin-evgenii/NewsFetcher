package org.seuge.newsfetcher.dao;

import org.seuge.newsfetcher.entities.RssFeed;

/**
 * RSS Feed repository
 * @author Eugene
 * @since 1.0
 */
public interface RssFeedRepo<FeedType extends RssFeed> extends FeedRepo<FeedType> {
}
