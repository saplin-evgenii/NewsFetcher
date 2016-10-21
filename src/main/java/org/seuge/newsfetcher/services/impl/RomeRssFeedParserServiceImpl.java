package org.seuge.newsfetcher.services.impl;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import org.seuge.newsfetcher.exceptions.ParsingException;
import org.seuge.newsfetcher.model.entities.RssFeed;
import org.seuge.newsfetcher.services.RssFeedParserService;
import org.seuge.newsfetcher.util.mappers.RssFeedMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * RSS feed parser service implemented with Rome library
 * @author Eugene
 * @since 1.0
 */
@Service
public class RomeRssFeedParserServiceImpl implements RssFeedParserService<RssFeed> {

    @Override
    public RssFeed parseFeed(final URL url) throws ParsingException {
        final RssFeed rssFeed;
        try {
            final SyndFeed feed = buildSyndFeed(url);
            rssFeed = RssFeedMapper.asRssFeed(feed);
        } catch (IOException | FeedException e) {
            throw new ParsingException(e);
        }
        return rssFeed;
    }

    private SyndFeed buildSyndFeed(final URL url) throws IOException, FeedException {
        final URLConnection connection = url.openConnection();
        final SyndFeedInput feedInput = new SyndFeedInput();
        final InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        final SyndFeed syndFeed = feedInput.build(reader);
        return syndFeed;
    }
}
