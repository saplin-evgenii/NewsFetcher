package org.seuge.newsfetcher.services.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seuge.newsfetcher.model.entities.RssFeed;
import org.seuge.newsfetcher.services.RssFeedParserService;
import org.seuge.newsfetcher.util.TestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 * @author Eugene
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/*Context.xml")
public class RomeRssFeedParserServiceImplTest {

    @Autowired
    private RssFeedParserService rssFeedParserService;

    @Test
    public void testParseFeed() throws Exception {
        final URL url = getClass().getClassLoader().getResource(TestConstants.RSS_FEED_SNIPPET_PATH);
        final RssFeed rssFeed = rssFeedParserService.parseFeed(url);
        assertEquals(TestConstants.RSS_FEED_SNIPPET_TITLE, rssFeed.getOriginalName());
        assertEquals(TestConstants.RSS_FEED_SNIPPET_TITLE, rssFeed.getShortName());
        //TODO: add feed URL match check
        assertEquals(TestConstants.RSS_FEED_SNIPPET_ITEMS_NUMBER, rssFeed.getItems().size());
    }
}
