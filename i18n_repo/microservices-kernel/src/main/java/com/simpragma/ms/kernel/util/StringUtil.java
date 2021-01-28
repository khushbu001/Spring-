/*
 * Copyright (c) 2018. Simpragma Solutions Private Limited
 */

package com.simpragma.ms.kernel.util;

/**
 * String utilities.
 *
 * @author mmh
 */
public class StringUtil {

    /**
     * Checks whether the given string is non-null and non-empty.
     *
     * @param str Given string
     * @return true if the string is non-empty false otherwise
     */
    public static boolean isPresent(final String str) {
        return str != null && !str.equals("");
    }
}
