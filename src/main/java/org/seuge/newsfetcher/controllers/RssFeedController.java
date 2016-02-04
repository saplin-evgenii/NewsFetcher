package org.seuge.newsfetcher.controllers;

import org.seuge.newsfetcher.entities.RssFeed;
import org.seuge.newsfetcher.services.RssFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rss Feed controller
 * @author Eugene
 * @since 1.0
 */
@RestController
@RequestMapping("/rssfeeds")
public class RssFeedController {

    @Autowired
    private RssFeedService rssFeedService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<RssFeed> getAllFeeds() {
        return rssFeedService.getAll();
    }
}
