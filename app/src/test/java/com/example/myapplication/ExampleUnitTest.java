package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Local unit tests for core utilities.
 * Runs on the development machine (JVM).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void constants_extraUserEmail_isCorrect() {
        assertEquals("USER_EMAIL", Constants.EXTRA_USER_EMAIL);
    }

    @Test
    public void constants_defaultUserName_isCorrect() {
        assertEquals("Alice", Constants.DEFAULT_USER_NAME);
    }
}
