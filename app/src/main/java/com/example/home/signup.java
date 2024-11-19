package com.example.home;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
public class signup extends AppCompatActivity {
    private EditText signUpUsername, signUpEmail, signUpPassword;
    private TextView loginbutton;
    private Button registerButton;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signUpUsername = findViewById(R.id.signUpUsername);
        signUpEmail = findViewById(R.id.signUpEmail);
        signUpPassword = findViewById(R.id.signUpPassword);
        loginbutton = findViewById(R.id.loginLink);
        registerButton = findViewById(R.id.registerButton);
        auth = FirebaseAuth.getInstance();
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = signUpUsername.getText().toString().trim();
                String email = signUpEmail.getText().toString().trim();
                String password = signUpPassword.getText().toString().trim();
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(signup.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(signup.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(signup.this, login.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(signup.this, "Registration Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signup.this, login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
