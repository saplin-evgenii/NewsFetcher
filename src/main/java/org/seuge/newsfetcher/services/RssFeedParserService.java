package org.seuge.newsfetcher.services;

import org.seuge.newsfetcher.exceptions.ParsingException;
import org.seuge.newsfetcher.model.entities.RssFeed;

import java.net.URL;

/**
 * RSS feed parser service
 * @author Eugene
 * @since 1.0
 */
public interface RssFeedParserService<FeedType extends RssFeed> extends FeedParserService<RssFeed> {

    /**
     * Parses feed located at specified URL
     * @param url URL where the feed to parse is located
     * @return Resulting feed
     * @throws ParsingException General parsing exception
     */
    RssFeed parseFeed(final URL url) throws ParsingException;
}
