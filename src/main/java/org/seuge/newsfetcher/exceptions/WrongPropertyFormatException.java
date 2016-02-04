package org.seuge.newsfetcher.exceptions;

import static org.seuge.newsfetcher.util.AppConfigConstants.WRONG_PROPERTY_FORMAT_MESSAGE;

/**
 * Wrong property format exception
 * @author Eugene
 * @since 1.0
 */
public class WrongPropertyFormatException extends AppConfigurationException {

    private final String propertyName;
    private final String propertyValue;

    public WrongPropertyFormatException(final String propertyName, final String propertyValue) {
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
    }

    public WrongPropertyFormatException(final String message, final String propertyName, final String propertyValue) {
        super(message);
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
    }

    public WrongPropertyFormatException(final String message,
                                        final Throwable cause,
                                        final String propertyName,
                                        final String propertyValue) {
        super(message, cause);
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
    }

    public WrongPropertyFormatException(final Throwable cause, final String propertyName, final String propertyValue) {
        super(cause);
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
    }

    @Override
    public String getMessage() {
        return String.format(WRONG_PROPERTY_FORMAT_MESSAGE, propertyName, propertyValue);
    }
}
