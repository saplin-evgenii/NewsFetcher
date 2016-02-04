package org.seuge.newsfetcher.services.impl;

import org.seuge.newsfetcher.exceptions.ConnectionException;
import org.seuge.newsfetcher.exceptions.LocalStorageException;
import org.seuge.newsfetcher.exceptions.ParsingException;
import org.seuge.newsfetcher.exceptions.PersistenceException;
import org.seuge.newsfetcher.services.AppConfigurerService;
import org.seuge.newsfetcher.services.NewsFetcherService;
import org.seuge.newsfetcher.util.AppConfigConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * Default implementation of SchedulerService
 * @author Eugene
 * @since 1.0
 */
@Service
@DependsOn("appConfigurerService")
public class DefaultSchedulerServiceImpl implements org.seuge.newsfetcher.services.SchedulerService {

    private class OverallUpdateTask implements Runnable {

        @Override
        public void run() {
            try {
                newsFetcherService.fetchNewsAll();
            } catch (ConnectionException | ParsingException | PersistenceException | LocalStorageException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Autowired
    private TaskScheduler scheduler;
    @Autowired
    private AppConfigurerService appConfigurerService;
    @Autowired
    private NewsFetcherService newsFetcherService;

    @Override
    @PostConstruct
    public void scheduleOverallUpdates() {
        final Properties configuration = appConfigurerService.getConfiguration();
        final String updateSchedule = configuration.getProperty(AppConfigConstants.SCHEDULED_UPDATE_CRON);
        scheduler.schedule(new OverallUpdateTask(), new CronTrigger(updateSchedule));
    }

}
