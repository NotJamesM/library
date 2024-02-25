package com.github.notjamesm.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean()
    public Logger applicationLogger() {
        return LoggerFactory.getLogger("APPLICATION");
    }

}
