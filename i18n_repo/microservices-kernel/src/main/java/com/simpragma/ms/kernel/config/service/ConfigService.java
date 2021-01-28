package com.simpragma.ms.kernel.config.service;

import com.simpragma.ms.kernel.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * Service for configuration.
 *
 * @author mmh
 */
@Service
public class ConfigService {

    @Autowired
    private Configuration configuration;

    /**
     * Return all properties.
     *
     * @return all properties
     */
    public Map<String, String> getAll() {
        return this.configuration.getEnv();
    }

    /**
     * Return the property for the given key.
     *
     * @return property for the given key.
     */
    public String get(String key) {
        return this.configuration.getProperty(key);
    }

    /**
     * Sets the properties.
     *
     * Note: It overwrites any existing properties.
     *
     * @param properties Contains the properties to set in the configuration.
     */
    public void set(@RequestBody Map<String, String> properties) {
        this.configuration.setEnv(properties);
    }

}
