package com.example.csistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }
    public void gotohomescreen(View view) {
        Intent intent = new Intent(this, homescreen.class);
        startActivity(intent);
    }
    public void gotoProfilePage(View view) {
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }
    public void gotosettings(View view) {
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
    }


    public void gotocontactus(View view) {
        Intent intent = new Intent(this, ContactUs.class);
        startActivity(intent);
    }

    public void gotoprivacypolicy(View view) {
        Intent intent = new Intent(this, PrivacyPolicy.class);
        startActivity(intent);
    }

    public void gototermsnc(View view) {
        Intent intent = new Intent(this, TermsnC.class);
        startActivity(intent);
    }

    public void gotohelp(View view) {
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }
}