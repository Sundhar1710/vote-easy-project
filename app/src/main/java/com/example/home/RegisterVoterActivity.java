package com.example.home;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
public class RegisterVoterActivity extends AppCompatActivity {
    private EditText voterIdInput;
    private Button submitVoterIdButton;
    private FirebaseAuth auth;
    private FirebaseFirestore firestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_voter);
        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        voterIdInput = findViewById(R.id.voterIdInput);
        submitVoterIdButton = findViewById(R.id.submitVoterIdButton);
        submitVoterIdButton.setOnClickListener(view -> addVoterIdToFirestore());
    }
    private void addVoterIdToFirestore() {
        String voterId = voterIdInput.getText().toString().trim();
        if (TextUtils.isEmpty(voterId)) {
            Toast.makeText(this, "Please enter a voter ID", Toast.LENGTH_SHORT).show();
            return;
        }
        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            String userEmail = user.getEmail();
            if (userEmail != null && !TextUtils.isEmpty(userEmail)) {
                Map<String, Object> voterData = new HashMap<>();
                voterData.put("voterIdNumber", voterId);
                firestore.collection("users").document(userEmail)
                        .set(voterData)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(RegisterVoterActivity.this, "Voter ID added successfully!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(RegisterVoterActivity.this, "Failed to add voter ID.", Toast.LENGTH_SHORT).show();
                                    Log.e("RegisterVoterActivity", "Error adding voter ID", task.getException());
                                }
                            }
                        });
            } else {
                Toast.makeText(this, "User email not found. Please log in with an email account.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "User not authenticated. Please log in.", Toast.LENGTH_SHORT).show();
        }
    }
}
