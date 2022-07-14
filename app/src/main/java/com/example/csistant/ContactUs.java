package com.example.csistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
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
}