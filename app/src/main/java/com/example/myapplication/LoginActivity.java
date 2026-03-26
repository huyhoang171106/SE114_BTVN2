package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Entry point of the app — authenticates the user by email
 * and navigates to the profile screen on success.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnSignIn;
    private TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        bindViews();
        setupListeners();
    }

    private void bindViews() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        tvRegister = findViewById(R.id.tvRegister);
    }

    private void setupListeners() {
        btnSignIn.setOnClickListener(v -> {
            if (!ValidationUtils.validateEmail(etEmail, this)) {
                return;
            }
            navigateToProfile(etEmail.getText().toString().trim());
        });

        tvRegister.setOnClickListener(v -> navigateToRegister());
    }

    private void navigateToProfile(String email) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra(Constants.EXTRA_USER_EMAIL, email);
        startActivity(intent);
    }

    private void navigateToRegister() {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
