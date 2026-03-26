package com.example.myapplication;

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
    private EditText etProfileAvatarUrl;
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
        etProfileAvatarUrl = findViewById(R.id.etProfileAvatar);
        etProfileDescription = findViewById(R.id.etProfileDescription);
        ivAvatar = findViewById(R.id.ivAvatar);
        btnSave = findViewById(R.id.btnSave);
        btnLogout = findViewById(R.id.btnLogout);
    }

    private void populateFromIntent() {
        String userEmail = getIntent().getStringExtra(Constants.EXTRA_USER_EMAIL);

        if (userEmail != null && !userEmail.isEmpty()) {
            tvWelcome.setText(R.string.welcome_message);
            etProfileEmail.setText(userEmail);
        }
    }

    private void setupListeners() {
        btnSave.setOnClickListener(v -> {
            String email = etProfileEmail.getText().toString().trim();

            if (email.isEmpty()) {
                etProfileEmail.setError(getString(R.string.error_email_required));
                return;
            }

            // TODO: persist profile changes to backend or local storage
            Toast.makeText(this, R.string.profile_saved, Toast.LENGTH_SHORT).show();
        });

        btnLogout.setOnClickListener(v -> finish());
    }
}
