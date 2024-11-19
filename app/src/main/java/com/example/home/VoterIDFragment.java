package com.example.home;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
public class VoterIDFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for the fragment
        View view = inflater.inflate(R.layout.fragment_voter_id, container, false);

        // Initialize the Button by finding it in the layout
        // Declare the Button
        Button submitButtonvoter = view.findViewById(R.id.submit_voter_id);

        // Set an OnClickListener for the button
        submitButtonvoter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the CandidateDetailsActivity when the button is clicked
                Intent intent = new Intent(getActivity(), candidate_details.class);
                startActivity(intent); // Start the CandidateDetailsActivity
            }
        });

        return view;
    }
}
