package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Registration screen — collects user name, email, and password.
 * Validates all fields before completing registration.
 */
public class RegisterActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        bindViews();
        setupListeners();
    }

    private void bindViews() {
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
    }

    private void setupListeners() {
        btnRegister.setOnClickListener(v -> handleRegister());
    }

    private void handleRegister() {
        int minLength = getResources().getInteger(R.integer.min_password_length);

        // Validate each field; stop at the first failure
        if (!ValidationUtils.validateRequired(etName, this, R.string.error_name_required)) {
            return;
        }
        if (!ValidationUtils.validateEmail(etEmail, this)) {
            return;
        }
        if (!ValidationUtils.validatePassword(etPassword, this, minLength)) {
            return;
        }

        String password = etPassword.getText().toString();
        String confirm = etConfirmPassword.getText().toString();
        if (!ValidationUtils.valuesMatch(password, confirm)) {
            etConfirmPassword.setError(getString(R.string.error_passwords_mismatch));
            return;
        }

        Toast.makeText(this, R.string.registration_success, Toast.LENGTH_SHORT).show();
        finish();
    }
}
