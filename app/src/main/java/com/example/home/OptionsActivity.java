package com.example.home;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class OptionsActivity extends AppCompatActivity {
    private String[] options = {
            "About App", "FAQ", "Important Document", "Feedback", "Contact", "Facebook", "Instagram", "YouTube"
    };
    private int[] icons = {R.drawable.aboutapp, R.drawable.faq, R.drawable.important_document, R.drawable.feedback,
            R.drawable.contact, R.drawable.facebook, R.drawable.instagram, R.drawable.youtube
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        ListView listView = findViewById(R.id.options_list);
        CustomAdapter adapter = new CustomAdapter(options, icons);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = options[position];
                if (position == 0) {
                    Intent intent = new Intent(OptionsActivity.this, aboutapp.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(OptionsActivity.this, feedback.class);
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(OptionsActivity.this, contact.class);
                    startActivity(intent);
                }
                if (position == 5) {
                    String facebookPageUrl = "https://www.facebook.com/";
                    String facebookAppUri = "https://www.facebook.com/";
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookAppUri));
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookPageUrl));
                        startActivity(intent);
                    }
                }
                if (position == 6) {
                    String instagramPageUrl = "https://www.instagram.com/accounts/login/?next=%2Faccounts%2Fremove%2Frequest%2Fpermanent%2F";
                    String instagramAppUri = "https://www.instagram.com/call_me_sai_ss_?igsh=YzQzdGtpbDJza3pj";
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramAppUri));
                        intent.setPackage("com.instagram.android");
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramPageUrl));
                        startActivity(intent);
                    }
                }
                if (position == 7) {
                    String youtubeChannelUrl = "https://www.youtube.com/watch?v=b--tgIsSZ-Y&list=RDb--tgIsSZ-Y&start_radio=1";
                    String youtubeAppUri = "https://youtube.com/@easytuto1?si=OHMR7o12ujqXvHIb";
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeAppUri));
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeChannelUrl));
                        startActivity(intent);
                    }
                }
            }
        });
    }
    class CustomAdapter extends ArrayAdapter<String> {
        private final String[] options;
        private final int[] icons;
        CustomAdapter(String[] options, int[] icons) {
            super(OptionsActivity.this, R.layout.list_item, options);
            this.options = options;
            this.icons = icons;
        }
        @Override
        public View getView(int position, View convertView, android.view.ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            }
            ImageView iconImageView = convertView.findViewById(R.id.icon);
            TextView optionTextView = convertView.findViewById(R.id.option_name);
            iconImageView.setImageResource(icons[position]);
            optionTextView.setText(options[position]);
            return convertView;
        }
    }
}
