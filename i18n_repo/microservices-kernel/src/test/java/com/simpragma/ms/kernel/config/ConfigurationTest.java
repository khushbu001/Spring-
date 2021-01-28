/*
 * Copyright (c) 2018. Simpragma Solutions Private Limited
 */

package com.simpragma.ms.kernel.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.simpragma.ms.kernel.config.Configuration.*;
import static org.junit.jupiter.api.Assertions.*;

class ConfigurationTest {

    Configuration configuration = new Configuration();

    @BeforeEach
    void populateConfig() {
        Map<String, String> props = new HashMap<>();

        props.put("url", "http://simpragma.com");
        props.put("port", "3000");
        props.put("timeout", "100000200000300");
        props.put("pi", "3.14256738");
        props.put("size", "0.12345678912345");
        props.put("active", "true");

        configuration.setEnv(props);
    }

    @Test void getProperty() {
        assertEquals("http://simpragma.com", configuration.getProperty("url"),
                "for string config");
        assertEquals("3000", configuration.getProperty("port"),
                "for string config");
        assertEquals("100000200000300", configuration.getProperty("timeout"),
                "for int config");
        assertEquals("3.14256738", configuration.getProperty("pi"),
                "for float config");
        assertEquals("0.12345678912345", configuration.getProperty("size"),
                "for double config");
        assertEquals("true", configuration.getProperty("active"),
                "for boolean config");
    }

    @Test void getPropertyWithDefaultValue() {
        assertEquals(null, configuration.getProperty("max_threads"),
                "for string config");
        assertEquals("5", configuration.getProperty("max_threads", "5"),
                "for string config");
        assertEquals("3000", configuration.getProperty("port", "5555"),
                "for string config");

    }

    @Test void getBoolProperty() {
        assertEquals(true, configuration.getBoolProperty("active"),
                "for boolean config");
        assertEquals(false, configuration.getBoolProperty("status.no.key"),
                "for boolean config");
    }

    @Test void getBoolPropertyWithDefaultValue() {
        assertEquals(true, configuration.getBoolProperty("active", false),
                "for boolean config");
        assertEquals(true, configuration.getBoolProperty("status.no.key", true),
                "for boolean config");
    }

    @Test void getIntProperty() {
        assertEquals(3000, configuration.getIntProperty("port"),
                "for int config");
        assertEquals(INT_CONFIG_DEFAULT, configuration.getIntProperty("db.port.no.key"),
                "for int config");
    }

    @Test void getIntPropertyWithDefaultValue() {
        assertEquals(3000, configuration.getIntProperty("port", 5555),
                "for int config");
        assertEquals(5555, configuration.getIntProperty("db.port.no.key", 5555),
                "for int config");
    }

    @Test void getLongProperty() {
        assertEquals(100000200000300L, configuration.getLongProperty("timeout"),
                "for long config");
        assertEquals(LONG_CONFIG_DEFAULT, configuration.getIntProperty("db.port.no.key"),
                "for long config");
    }

    @Test void getLongPropertyWithDefaultValue() {
        assertEquals(100000200000300L, configuration.getLongProperty("timeout",
                55),"for long config");
        assertEquals(122222233333300L, configuration.getLongProperty("db.port.no.key",
                122222233333300L),"for long config");
    }

    @Test void getFloatProperty() {
        assertEquals(3.14256738F, configuration.getFloatProperty("pi"),
                "for float config");
        assertEquals(FLOAT_CONFIG_DEFAULT, configuration.getFloatProperty("avail.no.key"),
                "for float config");
    }

    @Test void getFloatPropertyWithDefaultValue() {
        assertEquals(3.14256738F, configuration.getFloatProperty("pi",
                99.999F),"for float config");
        assertEquals(99.999F, configuration.getFloatProperty("avail.no.key",
                99.999F),"for float config");
    }

    @Test void getDoubleProperty() {
        assertEquals(0.12345678912345, configuration.getDoubleProperty("size"),
                "for double config");
        assertEquals(DOUBLE_CONFIG_DEFAULT, configuration.getDoubleProperty("size.no.key"),
                "for double config");
    }

    @Test void getDoublePropertyWithDefaultValue() {
        assertEquals(0.12345678912345, configuration.getDoubleProperty("size",
                99.999),"for double config");
        assertEquals(9999999.9999999999, configuration.getDoubleProperty("size.no.key",
                9999999.9999999999),"for float config");
    }

    @Test void addPropertyReplaceExistingValue() {
        String port = "port";
        assertEquals(3000, configuration.getIntProperty(port),
                "for int config");
        configuration.addProperty(port, "9999");
        assertEquals(9999, configuration.getIntProperty(port),
                "for int config");

        // check other configuration is not affected
        assertEquals(0.12345678912345, configuration.getDoubleProperty("size",
                99.999),"for double config");
    }

    @Test void addPropertyNew() {
        String key = "db.user";
        assertEquals(null, configuration.getProperty(key),
                "for string config");
        configuration.addProperty(key, "mmh");
        assertEquals("mmh", configuration.getProperty(key),
                "for string config");

        // check other configuration is not affected
        assertEquals(0.12345678912345, configuration.getDoubleProperty("size",
                99.999),"for double config");
    }

    @Test void setPropertiesReplaceExisting() {

        // First assert all env are set
        assertEquals("http://simpragma.com", configuration.getProperty("url"),
                "for string config");
        assertEquals("3000", configuration.getProperty("port"),
                "for string config");
        assertEquals("100000200000300", configuration.getProperty("timeout"),
                "for int config");
        assertEquals("3.14256738", configuration.getProperty("pi"),
                "for float config");
        assertEquals("0.12345678912345", configuration.getProperty("size"),
                "for double config");
        assertEquals("true", configuration.getProperty("active"),
                "for boolean config");

        // Now, set the configuration to new one
        Map<String, String> props = new HashMap<>();

        props.put("url", "http://simpragma.com/new");
        props.put("port", "9999");

        configuration.setEnv(props);

        // Assert new configuration env are set for the existing
        assertEquals("http://simpragma.com/new", configuration.getProperty("url"),
                "for string config");
        assertEquals("9999", configuration.getProperty("port"),
                "for string config");

        // Assert previous configuration still exists for the ones which are not replaced
        assertEquals("100000200000300", configuration.getProperty("timeout"),
                "for int config");
        assertEquals("3.14256738", configuration.getProperty("pi"),
                "for float config");
        assertEquals("0.12345678912345", configuration.getProperty("size"),
                "for double config");
        assertEquals("true", configuration.getProperty("active"),
                "for boolean config");
    }

    @Test void setPropertiesAddNew() {

        // First assert all env are set
        assertEquals("http://simpragma.com", configuration.getProperty("url"),
                "for string config");
        assertEquals("3000", configuration.getProperty("port"),
                "for string config");
        assertEquals("100000200000300", configuration.getProperty("timeout"),
                "for int config");
        assertEquals("3.14256738", configuration.getProperty("pi"),
                "for float config");
        assertEquals("0.12345678912345", configuration.getProperty("size"),
                "for double config");
        assertEquals("true", configuration.getProperty("active"),
                "for boolean config");

        // Now, set the configuration to new one
        Map<String, String> props = new HashMap<>();

        props.put("db.url", "http://simpragma.com/new");
        props.put("db.port", "3000");

        configuration.setEnv(props);

        // Assert new configuration env are set
        assertEquals("http://simpragma.com/new", configuration.getProperty("db.url"),
                "for string config");
        assertEquals("3000", configuration.getProperty("db.port"),
                "for string config");

        // Assert previous configuration still exists
        assertEquals("http://simpragma.com", configuration.getProperty("url"),
                "for string config");
        assertEquals("3000", configuration.getProperty("port"),
                "for string config");
        assertEquals("100000200000300", configuration.getProperty("timeout"),
                "for int config");
        assertEquals("3.14256738", configuration.getProperty("pi"),
                "for float config");
        assertEquals("0.12345678912345", configuration.getProperty("size"),
                "for double config");        assertEquals("http://simpragma.com", configuration.getProperty("url"),
                "for string config");
        assertEquals("3000", configuration.getProperty("port"),
                "for string config");

        assertEquals("true", configuration.getProperty("active"),
                "for boolean config");
    }

}
