package com.example.home;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class candidate_details extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_details);
        Button voteButton1 = findViewById(R.id.vote_button1);
        Button voteButton2 = findViewById(R.id.vote_button2);
        Button voteButton3 = findViewById(R.id.vote_button3);
        Button voteButton4 = findViewById(R.id.vote_button4);
        Button voteButton5 = findViewById(R.id.vote_button5);
        voteButton1.setOnClickListener(v -> navigateToVoteSuccess("DMK", "Location: VELLORE", R.drawable.dmk_leader, R.drawable.dmk_image));
        voteButton2.setOnClickListener(v -> navigateToVoteSuccess("TVK", "Location: VELLORE", R.drawable.tvk_leader, R.drawable.vijay_flag));
        voteButton3.setOnClickListener(v -> navigateToVoteSuccess("ADMK", "Location: VELLORE", R.drawable.admk_leader_main, R.drawable.admk_flag));
        voteButton4.setOnClickListener(v -> navigateToVoteSuccess("CONGRESS", "Location: VELLORE", R.drawable.congress_leader, R.drawable.congress_flag));
        voteButton5.setOnClickListener(v -> navigateToVoteSuccess("BJP", "Location:VELLORE", R.drawable.bjp_leader_main, R.drawable.bjp_flag));
    }
    private void navigateToVoteSuccess(String name, String location, int candidateImage, int flagImage) {
        Intent intent = new Intent(candidate_details.this, VoteSuccessActivity.class);
        intent.putExtra("candidate_name", name);
        intent.putExtra("candidate_location", location);
        intent.putExtra("candidate_image", candidateImage);
        intent.putExtra("flag_image", flagImage);
        startActivity(intent);
    }
}
