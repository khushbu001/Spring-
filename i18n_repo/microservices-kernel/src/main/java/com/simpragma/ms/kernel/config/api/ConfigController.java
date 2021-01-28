package com.simpragma.ms.kernel.config.api;

import com.simpragma.ms.kernel.config.service.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * API controller for configuration.
 *
 * @author MMH
 */
@RestController
@RequestMapping(value = "/api/v1/config")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    private static final Logger log = LoggerFactory.getLogger(ConfigController.class);

    /**
     * Gets all the properties.
     *
     * @return the properties.
     */
    @GetMapping
    public Map<String, String> get() {
        log.trace("Entering method empty arguments");
        log.trace("Exiting method");
        return configService.getAll();
    }

    /**
     * Gets the specific property.
     *
     * @return the given property.
     */
    @GetMapping("/{propertyKey}")
    public String get(@PathVariable String propertyKey) {
        log.trace("Entering with propertyKey: {}", propertyKey);
        String val = configService.get(propertyKey);
        log.trace("Exiting method, returning {}", val);
        return val;
    }

    /**
     * Sets the properties.
     *
     * Note: It overwrites any existing properties.
     *
     * @param properties List of properties to be set in the configuration.
     */
    @PostMapping
    public void set(@RequestBody Map<String, String> properties) {
        String method = "set";

        log.trace("Entering method {} with properties: {}", method, properties);
        configService.set(properties);
        log.trace("Exiting method {}", method);
        return;
    }
}
