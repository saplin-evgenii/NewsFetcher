package org.seuge.newsfetcher.services.impl;

import org.apache.commons.collections4.IterableUtils;
import org.seuge.newsfetcher.dao.RssFeedRepo;
import org.seuge.newsfetcher.model.entities.RssFeed;
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
    public void create(RssFeed newRssFeed) {
        rssFeedRepo.save(newRssFeed);
    }

    @Override
    public RssFeed get(String originalName) {
        return rssFeedRepo.findByOriginalName(originalName);
    }

    @Override
    public List<RssFeed> getAll() {
        return IterableUtils.toList(rssFeedRepo.findAll());
    }

    @Override
    public void update(RssFeed newRssFeed) {
        final RssFeed rssFeed = rssFeedRepo.findByOriginalName(newRssFeed.getOriginalName());
        rssFeed.setShortName(newRssFeed.getShortName());
        rssFeed.setUrl(newRssFeed.getUrl());
        rssFeedRepo.save(rssFeed);
    }

    @Override
    public void delete(String originalName) {
        rssFeedRepo.deleteByOriginalName(originalName);
    }
}
