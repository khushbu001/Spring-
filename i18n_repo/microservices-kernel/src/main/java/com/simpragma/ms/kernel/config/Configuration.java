/*
 * Copyright (c) 2018. Simpragma Solutions Private Limited
 */

package com.simpragma.ms.kernel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Holds the configuration.
 *
 * @author MMH
 */
@Component
public class Configuration {

    @Autowired Environment env;

    public static final boolean BOOL_CONFIG_DEFAULT = false;
    public static final int INT_CONFIG_DEFAULT = -12345678;
    public static final long LONG_CONFIG_DEFAULT = -12345678L;
    public static final float FLOAT_CONFIG_DEFAULT = -1.2345678F;
    public static final double DOUBLE_CONFIG_DEFAULT = -1.2345678;

    /**
     * Adds the given key-value pair to the configuration.
     *
     * @param key The key part of the pair.
     * @param val Value for the key.
     */
    public void addProperty(final String key, final String val) {
        //TODO: Need to see how to set property in the environment
        // this.env.setProperty(key, val);
    }

    /**
     * Replaces the key-value pair from the given env. If the pair doesn't exist, adds them.
     *
     * @param env The configuration object.
     */
    public void setEnv(final Map<String, String> env) {
        //TODO: Need to see how to set property in the environment
        /*
        env.entrySet().stream().forEach(entry -> {
            this.env.remove(entry.getKey());
            this.env.setProperty(entry.getKey(), entry.getValue());
        });
        */
    }

    /**
     * Get all env.
     *
     * @return the configuration env.
     */
    public Map<String, String> getEnv() {
        //TODO: Need to see how to get all env in the environment
        return new HashMap<>();
        /*
        return env.entrySet().stream()
                .collect(Collectors.toMap(e -> (String) e.getKey(), e -> (String) e.getValue()));
         */
    }

    /**
     * Gets the value for the given key.
     *
     * @param key The key for which the value needs to be retrieved.
     * @return the value for the configuration property. If not set, returns null.
     */
    public String getProperty(final String key) {
        return env.getProperty(key);
    }

    /**
     * Gets the value for the given key.
     *
     * @param key    The key for which the value needs to be retrieved.
     * @param defVal Default value for the key.
     * @return the value for the configuration property.
     */
    public String getProperty(final String key, final String defVal) {
        return env.getProperty(key, defVal);
    }

    /**
     * Gets the boolean value for the given key.
     *
     * @param key The key for which the value needs to be retrieved.
     * @return the value for the configuration property. If not set, returns false.
     */
    public boolean getBoolProperty(final String key) {
        String val = env.getProperty(key);
        return val != null ? Boolean.valueOf(val) : BOOL_CONFIG_DEFAULT;
    }

    /**
     * Gets the boolean value for the given key.
     *
     * @param key    The key for which the value needs to be retrieved.
     * @param defVal Default value for the key.
     * @return the value for the configuration property.
     */
    public boolean getBoolProperty(final String key, final boolean defVal) {
        String val = env.getProperty(key);
        return val != null ? Boolean.valueOf(val) : defVal;
    }

    /**
     * Gets the int value for the given key.
     *
     * @param key The key for which the value needs to be retrieved.
     * @return the value for the configuration property.
     */
    public int getIntProperty(final String key) {
        String val = env.getProperty(key);
        return val != null ? Integer.valueOf(val) : INT_CONFIG_DEFAULT;
    }

    /**
     * Gets the int value for the given key.
     *
     * @param key    The key for which the value needs to be retrieved.
     * @param defVal Default value for the key.
     * @return the value for the configuration property.
     */
    public int getIntProperty(final String key, final int defVal) {
        String val = env.getProperty(key);
        return val != null ? Integer.valueOf(val) : defVal;
    }

    /**
     * Gets the long value for the given key.
     *
     * @param key The key for which the value needs to be retrieved.
     * @return the value for the configuration property.
     */
    public long getLongProperty(final String key) {
        String val = env.getProperty(key);
        return val != null ? Long.valueOf(val) : LONG_CONFIG_DEFAULT;
    }

    /**
     * Gets the long value for the given key.
     *
     * @param key    The key for which the value needs to be retrieved.
     * @param defVal Default value for the key.
     * @return the value for the configuration property.
     */
    public long getLongProperty(final String key, final long defVal) {
        String val = env.getProperty(key);
        return (val != null) ? Long.valueOf(val) : defVal;
    }

    /**
     * Gets the float value for the given key.
     *
     * @param key The key for which the value needs to be retrieved.
     * @return the value for the configuration property.
     */
    public float getFloatProperty(final String key) {
        String val = env.getProperty(key);
        return val != null ? Float.valueOf(val) : FLOAT_CONFIG_DEFAULT;
    }

    /**
     * Gets the float value for the given key.
     *
     * @param key    The key for which the value needs to be retrieved.
     * @param defVal Default value for the key.
     * @return the value for the configuration property.
     */
    public float getFloatProperty(final String key, final float defVal) {
        String val = env.getProperty(key);
        return val != null ? Float.valueOf(val) : defVal;
    }

    /**
     * Gets the double value for the given key.
     *
     * @param key The key for which the value needs to be retrieved.
     * @return the value for the configuration property.
     */
    public double getDoubleProperty(final String key) {
        String val = env.getProperty(key);
        return val != null ? Double.valueOf(val) : DOUBLE_CONFIG_DEFAULT;
    }

    /**
     * Gets the double value for the given key.
     *
     * @param key    The key for which the value needs to be retrieved.
     * @param defVal Default value for the key.
     * @return the value for the configuration property.
     */
    public double getDoubleProperty(final String key, final double defVal) {
        String val = env.getProperty(key);
        return val != null ? Double.valueOf(val) : defVal;
    }
}
