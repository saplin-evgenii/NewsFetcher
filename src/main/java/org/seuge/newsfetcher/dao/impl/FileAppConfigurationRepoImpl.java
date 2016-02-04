package org.seuge.newsfetcher.dao.impl;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.seuge.newsfetcher.dao.AppConfigurationRepo;
import org.seuge.newsfetcher.exceptions.AppConfigurationException;
import org.springframework.stereotype.Repository;

import java.util.Properties;

import static org.seuge.newsfetcher.util.AppConfigConstants.*;

/**
 * Application configuration repository based on a config file
 * @author Eugene
 * @since 1.0
 */
@Repository
public class FileAppConfigurationRepoImpl implements AppConfigurationRepo {

    @Override
    public Properties loadConfiguration() throws AppConfigurationException {
        Properties props = new Properties();
        Configuration config = null;
        try {
            config = new PropertiesConfiguration("META-INF/app/" + CONFIG_FILE_NAME);
        } catch (ConfigurationException e) {
            throw new AppConfigurationException(e);
        }
        loadUpdateSchedule(config, props);
        return props;
    }

    @Override
    public void saveConfiguration(final Properties props) throws AppConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration();
        // saving future properties
        try {
            config.save("META-INF/app/" + CONFIG_FILE_NAME);
        } catch (ConfigurationException e) {
            throw new AppConfigurationException(e);
        }
    }

    private void loadUpdateSchedule(final Configuration config, final Properties props) {
        String updateSchedule = config.getString(SCHEDULED_UPDATE_CRON);
        if (updateSchedule == null) {
            updateSchedule = SCHEDULED_UPDATE_DEFAULT;
        }
        props.put(SCHEDULED_UPDATE_CRON, updateSchedule);
    }
}
