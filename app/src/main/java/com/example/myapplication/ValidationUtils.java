package com.example.myapplication;

import android.content.Context;
import android.util.Patterns;
import android.widget.EditText;

/** Shared input validation utilities to avoid duplication across activities. */
public final class ValidationUtils {

    private ValidationUtils() {
        // Utility class — prevent instantiation
    }

    /** Returns true if the given string is a non-empty, valid email address. */
    public static boolean isValidEmail(String email) {
        return !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /** Sets an error on the field and returns false if the email is invalid. */
    public static boolean validateEmail(EditText field, Context context) {
        String email = field.getText().toString().trim();
        if (!isValidEmail(email)) {
            field.setError(context.getString(R.string.error_invalid_email));
            return false;
        }
        return true;
    }

    /** Returns true if the password meets the minimum length requirement. */
    public static boolean isPasswordStrongEnough(String password, int minLength) {
        return password.length() >= minLength;
    }

    /** Sets an error on the field and returns false if the password is too short. */
    public static boolean validatePassword(EditText field, Context context, int minLength) {
        String password = field.getText().toString();
        if (!isPasswordStrongEnough(password, minLength)) {
            field.setError(context.getString(R.string.error_password_too_short));
            return false;
        }
        return true;
    }

    /** Returns true if the string is non-empty. */
    public static boolean isNonEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    /** Sets an error on the field and returns false if the value is empty. */
    public static boolean validateRequired(EditText field, Context context, int errorResId) {
        if (!isNonEmpty(field.getText().toString().trim())) {
            field.setError(context.getString(errorResId));
            return false;
        }
        return true;
    }

    /** Returns true if both strings are equal. */
    public static boolean valuesMatch(String a, String b) {
        return a != null && a.equals(b);
    }
}
