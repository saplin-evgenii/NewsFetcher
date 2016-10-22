package org.seuge.newsfetcher.util;

/**
 * Application configuration property names constants
 * @author Eugene
 * @since 1.0
 */
public final class AppConfigConstants {

    public static final String CONFIG_FILE_NAME = "app.cfg";
    public static final String SCHEDULED_UPDATE_CRON = "scheduled_update_cron";
    public static final String SCHEDULED_UPDATE_DEFAULT = "*/30 * * * * *"; // every 30 minutes
    public static final String MANDATORY_PROPERTY_NOT_FOUND_MESSAGE =
        "Mandatory property %s was not found in configuration file";
    public static final String WRONG_PROPERTY_FORMAT_MESSAGE = "The format of value %s of property %s is wrong";
    public static final String QUEUE_OVERFLOW_MESSAGE = "Feed queue overflow: more than %d feed updates";
    public static final String DUPLICATE_FEED_MESSAGE = "Queue for feed with name \"%s\" already exists";
    public static final String FEED_NOT_FOUND_MESSAGE = "Queue for feed with name \"%s\" was not found";

    private AppConfigConstants() {
    }
}
