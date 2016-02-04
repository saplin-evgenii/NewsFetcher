package org.seuge.newsfetcher.exceptions;

import static org.seuge.newsfetcher.util.AppConfigConstants.MANDATORY_PROPERTY_NOT_FOUND_MESSAGE;

/**
 * Mandatory property not found exception
 * @author Eugene
 * @since 1.0
 */
public class MandatoryPropertyNotFoundException extends AppConfigurationException {

    private final String propertyName;

    public MandatoryPropertyNotFoundException(final String propertyName) {
        this.propertyName = propertyName;
    }

    public MandatoryPropertyNotFoundException(final String message, final String propertyName) {
        super(message);
        this.propertyName = propertyName;
    }

    public MandatoryPropertyNotFoundException(final String message, final Throwable cause, final String propertyName) {
        super(message, cause);
        this.propertyName = propertyName;
    }

    public MandatoryPropertyNotFoundException(final Throwable cause, final String propertyName) {
        super(cause);
        this.propertyName = propertyName;
    }

    @Override
    public String getMessage() {
        return String.format(MANDATORY_PROPERTY_NOT_FOUND_MESSAGE, propertyName);
    }
}
