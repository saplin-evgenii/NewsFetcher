package org.seuge.newsfetcher.exceptions;

import org.seuge.newsfetcher.util.AppConfigConstants;

/**
 * Feed updates queue not found exception
 * @author Eugene
 * @since 1.0
 */
public class FeedNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return AppConfigConstants.FEED_NOT_FOUND_MESSAGE;
    }
}
