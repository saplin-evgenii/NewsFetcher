package org.seuge.newsfetcher.util.mappers;

import com.sun.syndication.feed.synd.SyndEntry;
import org.seuge.newsfetcher.model.entities.RssFeedItem;

/**
 * RssFeedMapper
 * @author Eugene
 * @since 1.0
 */
public final class RssFeedItemMapper {

    private RssFeedItemMapper() {
    }

    public static RssFeedItem asRssFeedItem(final SyndEntry syndEntry) {
        final RssFeedItem rssFeedItem = new RssFeedItem();
        rssFeedItem.setTitle(syndEntry.getTitle());
        final String description = syndEntry.getDescription().getValue();
        rssFeedItem.setDescription(description);
        return rssFeedItem;
    }
}
