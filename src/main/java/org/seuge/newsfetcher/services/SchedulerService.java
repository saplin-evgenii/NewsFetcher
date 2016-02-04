package org.seuge.newsfetcher.services;

import javax.annotation.PostConstruct;

/**
 * Service schedules different kinds of actions that the application might need, e.g. fetching feed updates
 * @author Eugene
 * @since 1.0
 */
public interface SchedulerService {

    /**
     * Schedules mandatory feed updates for all the feed registered; this operation cannot be omitted
     */
    @PostConstruct
    void scheduleOverallUpdates();
}
