package org.seuge.newsfetcher.model.feed_updates;

import org.seuge.newsfetcher.model.entities.FeedItem;

/**
 * New incoming item of a feed.
 * @author Eugene
 * @since 1.0
 */
public class FeedNewItemUpdate<FeedItemType extends FeedItem> extends FeedUpdate {

    private final FeedItemType newFeedItem;

    public FeedNewItemUpdate(FeedItemType newFeedItem) {
        this.newFeedItem = newFeedItem;
    }

    public FeedItemType getNewFeedItem() {
        return newFeedItem;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        FeedNewItemUpdate<?> that = (FeedNewItemUpdate<?>) o;

        return !(newFeedItem != null ? !newFeedItem.equals(that.newFeedItem) : that.newFeedItem != null);

    }

    @Override public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (newFeedItem != null ? newFeedItem.hashCode() : 0);
        return result;
    }

    @Override public String toString() {
        return "FeedNewItemUpdate{" +
                "newFeedItem=" + newFeedItem +
                "} " + super.toString();
    }
}
