package com.example.home;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class status extends AppCompatActivity {
    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        TextView appNumberText = findViewById(R.id.appNumberText);
        TextView dobText = findViewById(R.id.dobText);
        TextView applicationStatus = findViewById(R.id.applicationStatus);
        Intent intent = getIntent();
        String appNumber = intent.getStringExtra("applicationNumber");
        String dob = intent.getStringExtra("dob");
        appNumberText.setText("Application Number: " + appNumber);
        dobText.setText("Date of Birth: " + dob);
        applicationStatus.setText("Status: Your application is being processed.");
    }
}
