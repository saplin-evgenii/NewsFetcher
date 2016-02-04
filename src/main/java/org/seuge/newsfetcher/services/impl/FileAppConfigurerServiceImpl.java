package org.seuge.newsfetcher.services.impl;

import org.seuge.newsfetcher.dao.AppConfigurationRepo;
import org.seuge.newsfetcher.exceptions.AppConfigurationException;
import org.seuge.newsfetcher.services.AppConfigurerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * Application configurer based on a config file
 * @author Eugene
 * @since 1.0
 */
@Service("appConfigurerService")
public class FileAppConfigurerServiceImpl implements AppConfigurerService {

    @Autowired
    private AppConfigurationRepo appConfigurationRepo;

    private Properties configuration;

    @Override
    public Properties getConfiguration() {
        return configuration;
    }

    @Override
    public void setConfiguration(final Properties configuration) {
        this.configuration = configuration;
    }

    @PostConstruct
    @Override
    public void loadConfiguration() throws AppConfigurationException {
        configuration = appConfigurationRepo.loadConfiguration();
    }

    @Override
    public void saveConfiguration() throws AppConfigurationException {
        appConfigurationRepo.saveConfiguration(configuration);
    }
}
