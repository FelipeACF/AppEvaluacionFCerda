package com.example.appevaluacionfcerda;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.view.View;
import android.os.Handler;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUser;
    private EditText editTextPassword;
    private Button buttonLogin;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUser = findViewById(R.id.editTextUser);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        progressBar = findViewById(R.id.progressBar);

        buttonLogin.setOnClickListener(view -> {
            progressBar.setVisibility(View.VISIBLE);
            buttonLogin.setEnabled(false);

            new Handler().postDelayed(() -> {
                progressBar.setVisibility(View.INVISIBLE);
                startActivity(new Intent(LoginActivity.this, MainMenu.class));
                finish();
            }, 3000);
        });

        editTextUser.addTextChangedListener(textWatcher);
        editTextPassword.addTextChangedListener(textWatcher);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String user = editTextUser.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();
            buttonLogin.setEnabled(!user.isEmpty() && !password.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {}
    };
}
