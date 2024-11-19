package com.example.home;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class track_application extends AppCompatActivity {
    private EditText appNumberInput, dobInput;
    private Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_application);
        appNumberInput = findViewById(R.id.appNumberInput);
        dobInput = findViewById(R.id.dobInput);
        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String appNumber = appNumberInput.getText().toString().trim();
                String dob = dobInput.getText().toString().trim();
                if (appNumber.isEmpty() || dob.isEmpty()) {
                    appNumberInput.setError("Please enter both Application Number and Date of Birth");
                } else {
                    Intent intent = new Intent(track_application.this, status.class);
                    intent.putExtra("applicationNumber", appNumber);
                    intent.putExtra("dob", dob);
                    startActivity(intent);
                }
            }
        });
    }
}
