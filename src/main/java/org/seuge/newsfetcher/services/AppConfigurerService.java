package org.seuge.newsfetcher.services;

import org.seuge.newsfetcher.exceptions.AppConfigurationException;

import java.util.Properties;

/**
 * Service manages configuration of the entire application
 * @author Eugene
 * @since 1.0
 */
public interface AppConfigurerService {

    /**
     * Returns the current configuration as the set of properties
     * @return Set of configuration properties
     */
    Properties getConfiguration();

    /**
     * Sets a new configuration as the set of properties
     * @param configuration Set of configuration properties
     */
    void setConfiguration(final Properties configuration);

    /**
     * Loads the configuration from a persistent source specified by implementation
     * @throws AppConfigurationException General configuration exception
     */
    void loadConfiguration() throws AppConfigurationException;

    /**
     * Saves the configuration into a persistence source specified by implementation
     * @throws AppConfigurationException General configuration exception
     */
    void saveConfiguration() throws AppConfigurationException;
}
