package org.seuge.newsfetcher.util.mappers;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import org.seuge.newsfetcher.entities.RssFeed;
import org.seuge.newsfetcher.entities.RssFeedItem;

import java.util.ArrayList;
import java.util.List;

/**
 * RssFeedMapper
 * @author Eugene
 * @since 1.0
 */
public final class RssFeedMapper {

    private RssFeedMapper() {
    }

    public static RssFeed<RssFeedItem> asRssFeed(final SyndFeed syndFeed) {
        final RssFeed<RssFeedItem> feed = new RssFeed<>();
        feed.setOriginalName(syndFeed.getTitle());
        feed.setShortName(syndFeed.getTitle());
        feed.setUrl(syndFeed.getUri());
        final List<SyndEntry> entries = syndFeed.getEntries();
        final List<RssFeedItem> items = new ArrayList<>();
        for (final SyndEntry entry : entries) {
            final RssFeedItem feedItem = RssFeedItemMapper.asRssFeedItem(entry);
            items.add(feedItem);
        }
        feed.setItems(items);
        return feed;
    }
}
