package com.example.csistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Notification extends AppCompatActivity {
    TextView eventName,eventTime,eventDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        //@sf tv_message instead of message in original code


        Log.e("Sf","inside notification class");
        eventName = findViewById(R.id.message);
        eventTime = findViewById(R.id.time);
        eventDate = findViewById(R.id.date);

        Bundle bundle = getIntent().getExtras();
        //call the data which is passed by another intent
        eventName.setText(bundle.getString("eventname"));
        eventTime.setText(bundle.getString("eventtime"));
        eventDate.setText(bundle.getString("eventdate"));

    }
}