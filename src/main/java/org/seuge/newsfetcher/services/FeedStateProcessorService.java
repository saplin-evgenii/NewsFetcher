package org.seuge.newsfetcher.services;

/**
 * Processor compares previous and current states of a feed and puts the result as a feed update to the queue
 * @author Eugene
 * @since 1.0
 */
public interface FeedStateProcessorService {

    void processFeedsAll();

    void processFeed(String feedUrl);
}
