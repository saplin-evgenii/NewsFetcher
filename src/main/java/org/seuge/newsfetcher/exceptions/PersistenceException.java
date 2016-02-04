package org.seuge.newsfetcher.exceptions;

/**
 * General persistence exception
 * @author Eugene
 * @since 1.0
 */
public class PersistenceException extends Exception {

    public PersistenceException() {
    }

    public PersistenceException(final String message) {
        super(message);
    }

    public PersistenceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public PersistenceException(final Throwable cause) {
        super(cause);
    }

    public PersistenceException(final String message,
                                final Throwable cause,
                                final boolean enableSuppression,
                                final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
