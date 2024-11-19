package com.example.home;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import android.os.Handler;
import com.google.android.material.bottomnavigation.BottomNavigationView;
public class MainActivity extends AppCompatActivity {
    private LocationManager locationManager;
    private Handler gpsCheckHandler;
    private SharedPreferences preferences;
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("userPrefs", MODE_PRIVATE);
        boolean isLoggedIn = preferences.getBoolean("isLoggedIn", false);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (!isLoggedIn) {
            Intent intent = new Intent(MainActivity.this, login.class);
            startActivity(intent);
            finish();
            return;
        }
        CardView trackCard = findViewById(R.id.track_application_card);
        CardView voteCard = findViewById(R.id.vote_card);
        CardView modifyCard = findViewById(R.id.modify_voter_id_card);
        CardView newApplicationCard = findViewById(R.id.new_application_card);
        Button regvoteridbtn =  findViewById(R.id.voteridbtn);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        trackCard.setOnClickListener(v -> handleButtonClick(track_application.class));
        voteCard.setOnClickListener(v -> handleButtonClick(vote.class));
        modifyCard.setOnClickListener(v -> handleButtonClick(nri_new.class));
        newApplicationCard.setOnClickListener(v -> handleButtonClick(new_application.class));
        regvoteridbtn.setOnClickListener(v->handleButtonClick(RegisterVoterActivity.class));
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                startActivity(new Intent(this, MainActivity.class));
                return true;
            } else if (itemId == R.id.nav_enrollment) {
                // Start EnrollmentCenterActivity
                Intent enrollIntent = new Intent(this, enrollmentcenter.class);
                startActivity(enrollIntent);
                return true;
            } else if (itemId == R.id.nav_options) {
                // Start OptionsActivity
                Intent optionsIntent = new Intent(this, OptionsActivity.class);
                startActivity(optionsIntent);
                return true;
            }
            return false;
        });
    }
    private void handleButtonClick(Class<?> activityClass) {
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Intent intent = new Intent(MainActivity.this, activityClass);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Please enable GPS to use this feature.", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.user_profile) {
            Toast.makeText(this, "User Profile Clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.logout) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isLoggedIn", false);
            editor.apply();
            Intent intent = new Intent(MainActivity.this, login.class);
            startActivity(intent);
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}