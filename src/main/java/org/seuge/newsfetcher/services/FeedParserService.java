package org.seuge.newsfetcher.services;

import org.seuge.newsfetcher.exceptions.ParsingException;
import org.seuge.newsfetcher.model.entities.Feed;

import java.net.URL;

/**
 * Feed parser service
 * @author Eugene
 * @since 1.0
 */
public interface FeedParserService<FeedType extends Feed> {

    /**
     * Parses feed located at specified URL
     * @param url URL where the feed to parse is located
     * @return Resulting feed
     * @throws ParsingException General parsing exception
     */
    FeedType parseFeed(final URL url) throws ParsingException;
}
