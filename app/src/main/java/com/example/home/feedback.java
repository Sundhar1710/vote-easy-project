package com.example.home;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class feedback extends AppCompatActivity {
    private EditText etName, etEmail, etFeedback;
    private RatingBar ratingBar;
    private Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etFeedback = findViewById(R.id.et_feedback);
        ratingBar = findViewById(R.id.rating_bar);
        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String feedback = etFeedback.getText().toString().trim();
                float rating = ratingBar.getRating();
                if (name.isEmpty() || email.isEmpty() || feedback.isEmpty() || rating == 0) {
                    Toast.makeText(feedback.this, "Please fill in all fields and provide a rating", Toast.LENGTH_SHORT).show();
                } else {
                    String message = "Thank you for your feedback!\nRating: " + rating + " stars";
                    Toast.makeText(feedback.this, message, Toast.LENGTH_LONG).show();
                    etName.setText("");
                    etEmail.setText("");
                    etFeedback.setText("");
                    ratingBar.setRating(0);
                }
            }
        });
    }
}
