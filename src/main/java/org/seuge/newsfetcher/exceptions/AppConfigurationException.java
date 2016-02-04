package org.seuge.newsfetcher.exceptions;

/**
 * Application configuration exception
 * @author Eugene
 * @since 1.0
 */
public class AppConfigurationException extends Exception {

    public AppConfigurationException() {
    }

    public AppConfigurationException(final String message) {
        super(message);
    }

    public AppConfigurationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public AppConfigurationException(final Throwable cause) {
        super(cause);
    }
}
