package org.seuge.newsfetcher.controllers;

import org.seuge.newsfetcher.entities.RssFeed;
import org.seuge.newsfetcher.services.RssFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Rss Feed controller
 * @author Eugene
 * @since 1.0
 */
@Controller
@RequestMapping("/api/rssfeeds")
public class RssFeedController {

    @Autowired
    private RssFeedService rssFeedService;

    /**
     * REST command to create RSS feed
     * @param newRssFeed Request body representing RSS feed
     * @return 201 status
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<RssFeed> createFeed(@RequestBody RssFeed newRssFeed) {
        try {
            rssFeedService.create(newRssFeed);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * REST command to get RSS feed by original name in path
     * @param originalName original name of the feed to find
     * @return 200 / 404 status
     */
    @RequestMapping(value = "/{originalName}", method = RequestMethod.GET)
    public ResponseEntity<RssFeed> getFeed(@PathVariable("originalName") String originalName) {
        try {
            final RssFeed rssFeed = rssFeedService.get(originalName);
            if (rssFeed == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(rssFeed, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * REST command to get all the RSS feeds
     * @return 200 status
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<RssFeed>> getFeedsAll() {
        try {
            final List<RssFeed> all = rssFeedService.getAll();
            return new ResponseEntity<>(all, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * REST command to update the persisted feed that has the same original name
     * as given feed or persist the given feed if such a persisted feed was not found
     * @param newRssFeed Request body representing RSS feed
     * @return 200 status
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<RssFeed> updateFeed(@RequestBody RssFeed newRssFeed) {
        try {
            rssFeedService.update(newRssFeed);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * REST command to delete all the entities that have the given original name
     * @param originalName original name of the feed to delete
     * @return 204 status
     */
    @RequestMapping(value = "/{originalName}", method = RequestMethod.DELETE)
    public ResponseEntity<RssFeed> deleteFeed(@PathVariable("originalName") String originalName) {
        try {
            rssFeedService.delete(originalName);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
