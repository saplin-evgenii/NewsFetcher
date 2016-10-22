package org.seuge.newsfetcher.buffers.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seuge.newsfetcher.buffers.FeedsUpdatesContainer;
import org.seuge.newsfetcher.model.entities.FeedItem;
import org.seuge.newsfetcher.model.feed_updates.FeedNewItemUpdate;
import org.seuge.newsfetcher.model.feed_updates.FeedUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/*Context.xml")
public class FeedsUpdatesContainerTest {

    private static final Set<String> FEED_URLS =
            new HashSet<>(Arrays.asList("www.test1.rss", "www.test2.rss", "www.test3.rss"));
    private static final String NEW_FEED_URL = "www.test4.rss";

    @Autowired
    private FeedsUpdatesContainer feedsUpdatesContainer;

    @Before
    public void setUp() throws Exception {
        feedsUpdatesContainer.initContainer(FEED_URLS);
    }

    @Test
    @DirtiesContext
    public void testInitContainer() throws Exception {
        Assert.assertEquals(FEED_URLS.size(), feedsUpdatesContainer.feedsUrls().size());
        Assert.assertEquals(FEED_URLS, feedsUpdatesContainer.feedsUrls());
    }

    @Test
    @Ignore
    @DirtiesContext
    public void testAddFeed() throws Exception {
        Set<String> feedUrls = feedsUpdatesContainer.feedsUrls();
        int size = feedsUpdatesContainer.feedsUrls().size();
        feedsUpdatesContainer.addFeed(NEW_FEED_URL);
        Set<String> newFeedUrls = feedUrls;
        newFeedUrls.add(NEW_FEED_URL);
        Assert.assertEquals(newFeedUrls, feedsUpdatesContainer.feedsUrls());
        Assert.assertEquals(size + 1, feedsUpdatesContainer.feedsUrls().size());
    }

    @Test
    @Ignore
    @DirtiesContext
    public void testRemoveFeed() throws Exception {
        feedsUpdatesContainer.removeFeed(FEED_URLS.iterator().next());
        Assert.assertEquals(FEED_URLS.size() - 1, feedsUpdatesContainer.feedsUrls());
    }

    @Test
    @Ignore
    @DirtiesContext
    public void testGetNextUpdate() throws Exception {
        feedsUpdatesContainer.addFeed(NEW_FEED_URL);
        FeedItem feedItem = new FeedItem(1L, "test title", "test description");
        FeedUpdate feedUpdate = new FeedNewItemUpdate<>(feedItem);
        feedsUpdatesContainer.putUpdate(NEW_FEED_URL, feedUpdate);
        FeedUpdate newUpdate = feedsUpdatesContainer.getNextUpdate(NEW_FEED_URL);
        Assert.assertEquals(newUpdate, feedItem);
    }

    @Test
    @Ignore
    @DirtiesContext
    public void testPutUpdate() throws Exception {
        feedsUpdatesContainer.addFeed(NEW_FEED_URL);
        FeedItem feedItem = new FeedItem(1L, "test title", "test description");
        FeedUpdate feedUpdate = new FeedNewItemUpdate<>(feedItem);
        feedsUpdatesContainer.putUpdate(NEW_FEED_URL, feedUpdate);
        FeedUpdate newUpdate = feedsUpdatesContainer.getNextUpdate(NEW_FEED_URL);
        Assert.assertEquals(newUpdate, feedItem);
    }

    @Test
    @DirtiesContext
    public void testFeedsUrls() throws Exception {
        Set<String> feedUrls = feedsUpdatesContainer.feedsUrls();
        Assert.assertEquals(FEED_URLS, feedUrls);
    }
}
