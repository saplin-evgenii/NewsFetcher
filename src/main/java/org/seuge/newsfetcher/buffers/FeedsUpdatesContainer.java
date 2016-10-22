package org.seuge.newsfetcher.buffers;

import org.seuge.newsfetcher.exceptions.DuplicateFeedException;
import org.seuge.newsfetcher.exceptions.FeedNotFoundException;
import org.seuge.newsfetcher.model.feed_updates.FeedUpdate;

import java.util.Set;

/**
 * FeedsUpdatesContainer
 * @author Eugene Date		21.10.2016
 */
public interface FeedsUpdatesContainer {

    void initContainer(Set<String> feedUrls);

    Set<String> feedsUrls();

    void addFeed(String feedUrl) throws DuplicateFeedException;

    void removeFeed(String feedUrl) throws FeedNotFoundException;

    FeedUpdate getNextUpdate(String feedUrl)
            throws FeedNotFoundException;

    void putUpdate(String feedUrl, FeedUpdate feedUpdate)
            throws FeedNotFoundException;
}
