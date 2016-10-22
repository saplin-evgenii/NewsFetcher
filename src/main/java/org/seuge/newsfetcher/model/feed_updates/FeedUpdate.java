package org.seuge.newsfetcher.model.feed_updates;

import java.time.ZonedDateTime;

/**
 * Class that contains a single change of an attribute of a feed (new feed item, name, etc.).
 * @author Eugene
 * @since 1.0
 */
public abstract class FeedUpdate {

    private final ZonedDateTime timestamp;

    public FeedUpdate() {
        timestamp = ZonedDateTime.now();
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        FeedUpdate that = (FeedUpdate) o;

        return !(timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null);

    }

    @Override public int hashCode() {
        return timestamp != null ? timestamp.hashCode() : 0;
    }

    @Override public String toString() {
        return "FeedUpdate{" +
                "timestamp=" + timestamp +
                '}';
    }
}
