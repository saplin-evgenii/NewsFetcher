package org.seuge.newsfetcher.services.impl;

import org.seuge.newsfetcher.exceptions.ConnectionException;
import org.seuge.newsfetcher.exceptions.LocalStorageException;
import org.seuge.newsfetcher.exceptions.ParsingException;
import org.seuge.newsfetcher.services.NewsFetcherService;
import org.springframework.stereotype.Service;

/**
 * Default implementation of NewsFetcherService
 * @author Eugene
 * @since 1.0
 */
@Service
public class DefaultNewsFetcherServiceImpl implements NewsFetcherService {

    @Override
    public void fetchNewsAll() throws ConnectionException, ParsingException, LocalStorageException {
        System.out.println("hit");
    }
}
