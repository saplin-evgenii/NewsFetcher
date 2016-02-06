package org.seuge.newsfetcher.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Root controller
 * Created by Eugene on 02.02.2016.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    /**
     * Index page
     * @return page
     */
    @RequestMapping(method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }

    /**
     * Page with CRUD operations for RSS feeds
     * @return page
     */
    @RequestMapping(value = "rssFeeds", method = RequestMethod.GET)
    public String rssFeedsPage() {
        return "rssFeeds";
    }
}
