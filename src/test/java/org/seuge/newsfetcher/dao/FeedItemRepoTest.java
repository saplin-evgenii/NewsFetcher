package org.seuge.newsfetcher.dao;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seuge.newsfetcher.entities.FeedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/*Context.xml")
public class FeedItemRepoTest {

    public static final int ITEMS_NUMBER = 10;
    private static final Long UNREACHABLE_ID = Long.MAX_VALUE - ITEMS_NUMBER;

    @Autowired
    private FeedItemRepo feedItemRepo;

    private List<FeedItem> items;

    @Before
    public void setUp() throws Exception {
        items = createItems(ITEMS_NUMBER);
    }

    @After
    public void tearDown() throws Exception {
        deleteItems();
    }

    @Test
    public void testSearchByTitle() throws Exception {
        final Collection<FeedItem> titleItems = feedItemRepo.searchByTitle(items.get(0).getTitle());
        assertEquals(1, titleItems.size());
        assertEquals(items.get(0), titleItems.iterator().next());
    }

    @Test
    public void testFindAll() throws Exception {
        final Iterable<FeedItem> itemsAll = feedItemRepo.findAll();
        outer:
        items.stream()
            .forEach(item -> {
                for (final FeedItem allItem : itemsAll) {
                    if (item.equals(allItem)) {
                        return;
                    }
                }
                Assert.fail("One of the test items was not found");
            });
    }

    private List<FeedItem> createItems(final int itemsNumber) {
        List<FeedItem> items = IntStream.range(0, itemsNumber)
            .mapToObj(i -> {
                FeedItem item = new FeedItem();
                item.setId(UNREACHABLE_ID + i);
                item.setTitle(RandomStringUtils.random(10, true, true));
                item.setDescription(RandomStringUtils.random(10, true, true));
                feedItemRepo.save(item);
                return item;
            })
            .collect(Collectors.toList());
        return items;
    }

    private void deleteItems() {
        items.stream()
            .forEach(feedItemRepo::delete);
    }

}