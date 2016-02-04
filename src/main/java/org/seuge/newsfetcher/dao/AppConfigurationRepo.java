package org.seuge.newsfetcher.dao;

import org.seuge.newsfetcher.exceptions.AppConfigurationException;

import java.util.Properties;

/**
 * Application configuration repository
 * @author Eugene
 * @since 1.0
 */
public interface AppConfigurationRepo {

    /**
     * Loads the configuration from a persistent source specified by implementation
     * @throws AppConfigurationException General configuration exception
     */
    Properties loadConfiguration() throws AppConfigurationException;

    /**
     * Saves the configuration into a persistence source specified by implementation
     * @throws AppConfigurationException General configuration exception
     */
    void saveConfiguration(Properties props) throws AppConfigurationException;
}
