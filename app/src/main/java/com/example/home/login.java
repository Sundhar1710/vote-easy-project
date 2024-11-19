package com.example.home;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
public class login extends AppCompatActivity {
    private static final int REQUEST_LOCATION = 100;
    private EditText usernameInput, passwordInput;
    private TextView signupbutton;
    private Button loginButton;
    private LocationManager locationManager;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        signupbutton = findViewById(R.id.signUpText);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        auth = FirebaseAuth.getInstance();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = usernameInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(login.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(login.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                FirebaseUser user = auth.getCurrentUser();
                                if (user != null) {
                                    SharedPreferences preferences = getSharedPreferences("userPrefs", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = preferences.edit();
                                    editor.putBoolean("isLoggedIn", true);
                                    editor.apply();
                                    Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    checkGpsAndProceed();
                                }
                            } else {
                                Toast.makeText(login.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);
            }
        });
    }
    private void checkGpsAndProceed() {
        boolean isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!isGpsEnabled) {
            promptEnableGps();
        } else {
            goToHomePage();
        }
    }
    private void promptEnableGps() {
        Toast.makeText(this, "Enable Location", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivityForResult(intent, REQUEST_LOCATION);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_LOCATION) {
            boolean isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            if (isGpsEnabled) {
                goToHomePage();
            } else {
                Toast.makeText(this, "Please enable GPS to continue", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void goToHomePage() {
        Intent intent = new Intent(login.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
