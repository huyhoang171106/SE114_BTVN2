package com.example.myapplication;

/**
 * Centralized constants for intent extras and app-wide configuration.
 * Avoids magic strings scattered across activities.
 */
public final class Constants {

    private Constants() {
        // Utility class — prevent instantiation
    }

    // Intent extra keys
    public static final String EXTRA_USER_EMAIL = "USER_EMAIL";
    public static final String EXTRA_USER_NAME = "USER_NAME";
    public static final String EXTRA_USER_ADDRESS = "USER_ADDRESS";
    public static final String EXTRA_USER_AVATAR_URL = "USER_AVATAR_URL";
    public static final String EXTRA_USER_DESCRIPTION = "USER_DESCRIPTION";

    // Default values
    public static final String DEFAULT_USER_EMAIL = "test@mail.com";
    public static final String DEFAULT_USER_NAME = "Alice";
}
