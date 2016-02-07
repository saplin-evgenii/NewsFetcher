package org.seuge.newsfetcher.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Feed item represents a news element in a feed.
 * @author Eugene
 * @since 1.0
 */

@Document(collection = "feed_items")
public class FeedItem implements Serializable {

    /**
     * Unique item id
     */
    @Id
    private Long id;
    /**
     * Title of the news
     */
    private String title;
    /**
     * Content of the news
     */
    private String description;

    @PersistenceConstructor
    public FeedItem() {
    }

    @PersistenceConstructor
    public FeedItem(final Long id, final String title, final String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final FeedItem item = (FeedItem) o;

        if (id != null ? !id.equals(item.id) : item.id != null) return false;
        if (title != null ? !title.equals(item.title) : item.title != null) return false;
        return !(description != null ? !description.equals(item.description) : item.description != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            '}';
    }
}
