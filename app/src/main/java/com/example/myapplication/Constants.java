package com.example.myapplication;

/**
 * Centralized constants for intent extras and app-wide defaults.
 * Keeps magic strings out of activities.
 */
public final class Constants {

    // Intent extra keys
    public static final String EXTRA_USER_EMAIL = "USER_EMAIL";

    // Default values used by activities and layouts
    public static final String DEFAULT_USER_EMAIL = "test@mail.com";
    public static final String DEFAULT_USER_NAME = "Alice";
}
