package com.example.alc4challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mAlc;
    Button myProfile;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAlc = findViewById(R.id.aboutalc);
        myProfile = findViewById(R.id.myprofile);

        myProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMyProfile();
            }
        });

        mAlc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAlcAbout();
            }
        });
    }

    private void goToAlcAbout() {
        startActivity( new Intent(MainActivity.this, AboutALC.class));
//        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://andela.com/alc/"));
//        startActivity(browserIntent);
    }

    private void goToMyProfile() {
        startActivity( new Intent(MainActivity.this, MyProfile.class));
    }
}
