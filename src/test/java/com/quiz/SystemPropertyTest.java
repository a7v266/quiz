package com.quiz;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SystemPropertyTest {

    @BeforeClass
    public static void initSystemPropertyTest() {
        Environment.setProperty("initTestKey1", "initTestValue1");
    }

    @Test
    public void testClearSystemProperty() {
        System.setProperty("testKey", "testValue");
        Assert.assertEquals("testValue", System.getProperty("testKey"));
        System.clearProperty("testKey");
        Assert.assertNull(System.getProperty("testKey"));
    }
}
