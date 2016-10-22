package org.seuge.newsfetcher.buffers.impl;

import org.seuge.newsfetcher.buffers.FeedsUpdatesContainer;
import org.seuge.newsfetcher.exceptions.DuplicateFeedException;
import org.seuge.newsfetcher.exceptions.FeedNotFoundException;
import org.seuge.newsfetcher.model.feed_updates.FeedUpdate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Feeds' updates container based on the map of urls to queues
 * @author Eugene
 * @since 1.0
 */
@Component
public class DefaultFeedsUpdatesContainerImpl implements FeedsUpdatesContainer {

    //TODO: add queue limit logic

    private final Map<String, Queue<FeedUpdate>> feedsUpdates;

    public DefaultFeedsUpdatesContainerImpl() {
        feedsUpdates = new HashMap<>();
    }

    @Override
    public void initContainer(Set<String> feedUrls) {
        feedsUpdates.clear();
        feedUrls.stream()
                .forEach(feedUrl -> {
                    feedsUpdates.put(feedUrl, new LinkedList<>());
                });
    }

    public Set<String> feedsUrls() {
        return feedsUpdates.keySet();
    }

    @Override
    public void addFeed(String feedUrl) throws DuplicateFeedException {
        if (feedsUpdates.containsKey(feedUrl)) {
            throw new DuplicateFeedException(feedUrl);
        }
        feedsUpdates.put(feedUrl, new LinkedList<>());
    }

    @Override
    public void removeFeed(String feedUrl) throws FeedNotFoundException {
        if (!feedsUpdates.containsKey(feedUrl)) {
            throw new FeedNotFoundException();
        }
        feedsUpdates.remove(feedUrl);
    }

    @Override
    public FeedUpdate getNextUpdate(String feedUrl)
            throws FeedNotFoundException {
        if (!feedsUpdates.containsKey(feedUrl)) {
            throw new FeedNotFoundException();
        }
        return feedsUpdates.get(feedUrl).poll();
    }

    @Override
    public void putUpdate(String feedUrl, FeedUpdate feedUpdate)
            throws FeedNotFoundException {
        if (!feedsUpdates.containsKey(feedUrl)) {
            throw new FeedNotFoundException();
        }
        feedsUpdates.get(feedUrl).offer(feedUpdate);
    }
}
