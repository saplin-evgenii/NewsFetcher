package org.seuge.newsfetcher.exceptions;

import static org.seuge.newsfetcher.util.AppConfigConstants.DUPLICATE_FEED_MESSAGE;

/**
 * Feed updates queue overflow exception
 * @author Eugene
 * @since 1.0
 */
public class DuplicateFeedException extends Exception {

    private final String feedUrl;

    public DuplicateFeedException(final String feedUrl) {
        this.feedUrl = feedUrl;
    }

    @Override
    public String getMessage() {
        return String.format(DUPLICATE_FEED_MESSAGE, feedUrl);
    }
}
