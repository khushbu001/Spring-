/*
 * Copyright (c) 2018. Simpragma Solutions Private Limited
 */

package com.simpragma.ms.kernel.util;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @org.junit.jupiter.api.Test
    void isPresent() {
        assertEquals(false, StringUtil.isPresent(null),
                "for null string");
        assertEquals(false, StringUtil.isPresent(""),
                "for empty string");
        assertEquals(true,  StringUtil.isPresent("a"),
                "for non-empty string");
        assertEquals(true,  StringUtil.isPresent("abc"),
                "for non-empty string");
        assertEquals(true,  StringUtil.isPresent("    "),
                "failed for blank string");
    }

}
