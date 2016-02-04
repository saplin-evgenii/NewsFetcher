package org.seuge.newsfetcher.exceptions;

/**
 * General parsing exception
 * @author Eugene
 * @since 1.0
 */
public class ParsingException extends Exception {

    public ParsingException() {
    }

    public ParsingException(final String message) {
        super(message);
    }

    public ParsingException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ParsingException(final Throwable cause) {
        super(cause);
    }

    public ParsingException(final String message,
                            final Throwable cause,
                            final boolean enableSuppression,
                            final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
