package org.seuge.newsfetcher.exceptions;

/**
 * General local storage save exception
 * @author Eugene
 * @since 1.0
 */
public class LocalStorageException extends Exception {

    public LocalStorageException() {
    }

    public LocalStorageException(final String message) {
        super(message);
    }

    public LocalStorageException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public LocalStorageException(final Throwable cause) {
        super(cause);
    }

    public LocalStorageException(final String message,
                                 final Throwable cause,
                                 final boolean enableSuppression,
                                 final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
