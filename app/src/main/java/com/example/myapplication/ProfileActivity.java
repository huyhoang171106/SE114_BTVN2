package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Profile screen — displays and edits user information.
 * Pre-populated with data passed from the login screen.
 */
public class ProfileActivity extends AppCompatActivity {

    private TextView tvWelcome;
    private EditText etProfileName;
    private EditText etProfileEmail;
    private EditText etProfileAddress;
    private EditText etProfileAvatar;
    private EditText etProfileDescription;
    private ImageView ivAvatar;
    private Button btnSave;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        bindViews();
        populateFromIntent();
        setupListeners();
    }

    private void bindViews() {
        tvWelcome = findViewById(R.id.tvWelcome);
        etProfileName = findViewById(R.id.etProfileName);
        etProfileEmail = findViewById(R.id.etProfileEmail);
        etProfileAddress = findViewById(R.id.etProfileAddress);
        etProfileAvatar = findViewById(R.id.etProfileAvatar);
        etProfileDescription = findViewById(R.id.etProfileDescription);
        ivAvatar = findViewById(R.id.ivAvatar);
        btnSave = findViewById(R.id.btnSave);
        btnLogout = findViewById(R.id.btnLogout);
    }

    private void populateFromIntent() {
        String userEmail = getIntent().getStringExtra(Constants.EXTRA_USER_EMAIL);

        if (ValidationUtils.isNonEmpty(userEmail)) {
            tvWelcome.setText(R.string.welcome_message);
            etProfileEmail.setText(userEmail);
        }
    }

    private void setupListeners() {
        btnSave.setOnClickListener(v -> handleSave());
        btnLogout.setOnClickListener(v -> handleLogout());
    }

    private void handleSave() {
        if (!ValidationUtils.validateRequired(etProfileEmail, this, R.string.error_email_required)) {
            return;
        }
        // TODO: persist profile changes to backend or local storage
        Toast.makeText(this, R.string.profile_saved, Toast.LENGTH_SHORT).show();
    }

    private void handleLogout() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
