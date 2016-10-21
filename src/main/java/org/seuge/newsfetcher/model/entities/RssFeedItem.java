package org.seuge.newsfetcher.model.entities;

/**
 * Rss feed Item
 * @author Eugene
 * @since 1.0
 */
public class RssFeedItem extends FeedItem {

    public RssFeedItem() {
    }

    public RssFeedItem(Long id, String title, String description) {
        super(id, title, description);
    }
}
