package com.auth.ibct.ibct.config;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.yml")
public class ApplicationConfig {

    @Autowired
    private Environment env;

    public String getConfigurationValue(String configKey) {
        return env.getProperty(configKey);
    }
}