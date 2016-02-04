package org.seuge.newsfetcher.services;

import org.seuge.newsfetcher.exceptions.ConnectionException;
import org.seuge.newsfetcher.exceptions.LocalStorageException;
import org.seuge.newsfetcher.exceptions.ParsingException;
import org.seuge.newsfetcher.exceptions.PersistenceException;

/**
 * Service performs news fetching to the application local storage and persisting news into the database on the way
 * @author Eugene
 * @since 1.0
 */
public interface NewsFetcherService {

    /**
     * Fetches news for all the feeds registered and persists them into the database
     * @throws ConnectionException   General network connection exception
     * @throws ParsingException      General parsing exception
     * @throws PersistenceException  General persistence process exception
     * @throws LocalStorageException General local storage save exception
     */
    void fetchNewsAll() throws ConnectionException, ParsingException, PersistenceException, LocalStorageException;
}
