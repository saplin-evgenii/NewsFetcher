package org.seuge.newsfetcher.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Feed
 * @author Eugene
 * @since 1.0
 */
@Document(collection = "feeds")
public class Feed<FeedItemType extends FeedItem> {

    /**
     * Unique feed id
     */
    @Id
    private ObjectId id;

    /**
     * Name of the feed as it is defined in the feed
     */
    private String originalName;

    /**
     * Short name of the feed given by user
     */
    private String shortName;

    /**
     * URL which the feed is accessible on
     */
    private String url; //TODO: change to java.net.URL type

    /**
     * Items that form the feed
     */
    private List<FeedItemType> items;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(final String originalName) {
        this.originalName = originalName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(final String shortName) {
        this.shortName = shortName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public List<FeedItemType> getItems() {
        return items;
    }

    public void setItems(final List<FeedItemType> items) {
        this.items = items;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Feed feed = (Feed) o;

        if (originalName != null ? !originalName.equals(feed.originalName) : feed.originalName != null) return false;
        if (shortName != null ? !shortName.equals(feed.shortName) : feed.shortName != null) return false;
        if (url != null ? !url.equals(feed.url) : feed.url != null) return false;
        return !(items != null ? !items.equals(feed.items) : feed.items != null);

    }

    @Override
    public int hashCode() {
        int result = originalName != null ? originalName.hashCode() : 0;
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (items != null ? items.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Feed{" +
            "originalName='" + originalName + '\'' +
            ", shortName='" + shortName + '\'' +
            ", url=" + url +
            ", items=" + items +
            '}';
    }
}
