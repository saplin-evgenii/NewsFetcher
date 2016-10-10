package org.seuge.newsfetcher.util.mappers;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import org.seuge.newsfetcher.entities.RssFeed;
import org.seuge.newsfetcher.entities.RssFeedItem;

import java.util.List;
import java.util.stream.Collectors;

/**
 * RssFeedMapper
 * @author Eugene
 * @since 1.0
 */
public final class RssFeedMapper {

    private RssFeedMapper() {
    }

    public static RssFeed asRssFeed(final SyndFeed syndFeed) {
        final RssFeed feed = new RssFeed();
        feed.setOriginalName(syndFeed.getTitle());
        feed.setShortName(syndFeed.getTitle());
        feed.setUrl(syndFeed.getUri());
        final List<RssFeedItem> items = ((List<SyndEntry>) syndFeed.getEntries())
            .stream()
            .map(RssFeedItemMapper::asRssFeedItem)
            .collect(Collectors.toList());
        feed.setItems(items);
        return feed;
    }
}
