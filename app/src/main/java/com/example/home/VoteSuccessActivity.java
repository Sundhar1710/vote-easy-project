package com.example.home;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat; // Import ContextCompat
public class VoteSuccessActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_success);
        Intent intent = getIntent();
        String candidateName = intent.getStringExtra("candidate_name");
        String candidateLocation = intent.getStringExtra("candidate_location");
        int candidateImage = intent.getIntExtra("candidate_image", 0);
        int flagImage = intent.getIntExtra("flag_image", 0);
        ImageView candidateImageView = findViewById(R.id.candidate_image);
        TextView candidateNameTextView = findViewById(R.id.candidate_name);
        TextView candidateLocationTextView = findViewById(R.id.candidate_location);
        ImageView flagImageView = findViewById(R.id.parliament_flag);
        CheckBox confirmcheckbox = findViewById(R.id.confirm_checkbox);
        Button confirmButton = findViewById(R.id.confirm_button);
        TextView successMessageTextView = findViewById(R.id.vote_success_message);
        candidateImageView.setImageResource(candidateImage);
        candidateNameTextView.setText(candidateName);
        candidateLocationTextView.setText(candidateLocation);
        flagImageView.setImageResource(flagImage);
        successMessageTextView.setText("Vote Successful");
        confirmButton.setEnabled(false);
        confirmButton.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray));
        confirmcheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                confirmButton.setEnabled(true);
                confirmButton.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_green_light));
                Toast.makeText(VoteSuccessActivity.this, "Accepted Terms & Conditions", Toast.LENGTH_SHORT).show();
                confirmButton.setOnClickListener(v -> {
                    Intent mainIntent = new Intent(VoteSuccessActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                    Toast.makeText(VoteSuccessActivity.this, "voted successful to "+candidateName, Toast.LENGTH_SHORT).show();
                    finish();
                });
            } else {
                confirmButton.setEnabled(false);
                confirmButton.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray));
            }
        });
    }
}
