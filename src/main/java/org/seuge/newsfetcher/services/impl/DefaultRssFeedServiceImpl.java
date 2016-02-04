package org.seuge.newsfetcher.services.impl;

import org.apache.commons.collections4.IterableUtils;
import org.seuge.newsfetcher.dao.RssFeedRepo;
import org.seuge.newsfetcher.entities.RssFeed;
import org.seuge.newsfetcher.services.RssFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Default Rss Feed service implementation
 * @author Eugene
 * @since 1.0
 */
@Service
public class DefaultRssFeedServiceImpl implements RssFeedService {

    @Autowired
    private RssFeedRepo<RssFeed> rssFeedRepo;

    @Override
    public List<RssFeed> getAll() {
        return IterableUtils.toList(rssFeedRepo.findAll());
    }
}
