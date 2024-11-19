package com.example.home;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class new_application extends AppCompatActivity {
    private EditText editTextName, editTextDOB, editTextAddress, editTextAadhar;
    private RadioGroup radioGroupGender;
    private CheckBox checkBoxTerms;
    private Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_application);
        editTextName = findViewById(R.id.editTextText2);
        editTextDOB = findViewById(R.id.editTextText4);
        editTextAddress = findViewById(R.id.editTextText5);
        editTextAadhar = findViewById(R.id.editTextText6);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        checkBoxTerms = findViewById(R.id.checkBox);
        btnSubmit = findViewById(R.id.button2);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String dob = editTextDOB.getText().toString().trim();
                String address = editTextAddress.getText().toString().trim();
                String aadhar = editTextAadhar.getText().toString().trim();
                int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
                String gender = "";
                if (selectedGenderId != -1) {
                    RadioButton selectedGender = findViewById(selectedGenderId);
                    gender = selectedGender.getText().toString();
                }
                boolean isTermsAccepted = checkBoxTerms.isChecked();
                if (name.isEmpty() || dob.isEmpty() || address.isEmpty() || aadhar.isEmpty() || gender.isEmpty()) {
                    Toast.makeText(new_application.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (!isTermsAccepted) {
                    Toast.makeText(new_application.this, "You must agree to the terms and conditions", Toast.LENGTH_SHORT).show();
                } else {
                    String message = "Submission Successful!\n" +
                            "Name: " + name + "\n" +
                            "DOB: " + dob + "\n" +
                            "Address: " + address + "\n" +
                            "Gender: " + gender + "\n" +
                            "Aadhar: " + aadhar;
                    Toast.makeText(new_application.this, message, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
