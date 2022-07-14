package com.example.csistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class homescreen extends AppCompatActivity {

    FloatingActionButton mCreateRem;
    UserModel user;
    private FloatingActionButton butAddRem;
    private RecyclerView mRecyclerview;
    private RecyclerView.Adapter adapter;
    ArrayList<Model> dataHolder = new ArrayList<Model>();       //Array list to add reminders and display in recyclerview

    public void gotoHomescreen(View view) {
        Intent intent = new Intent(this, homescreen.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }

    public void gotoCreteEvent(View view) {
        Intent intent = new Intent(this, createEvent.class);
        startActivity(intent);
    }

    public void gotoProfile(View view){
        Intent intent = new Intent(this,ProfilePage.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }

    public void gotoSettings(View view){
        Intent intent = new Intent(this,Setting.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        Intent intent = getIntent();
        user = (UserModel) intent.getSerializableExtra("user");

        butAddRem = (FloatingActionButton)findViewById(R.id.addRemBut);
        butAddRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homescreen.this, createEvent.class);
                startActivity(intent);
            }
        });

        //RecyclerView
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Cursor cursor = new DBHandler(getApplicationContext()).readAllReminders();                  //Cursor To Load data From the database
        while (cursor.moveToNext()) {
            Model model = new Model(cursor.getString(1), cursor.getString(2), cursor.getString(3));
            dataHolder.add(model);
        }
        //Binds the adapter with recyclerview
        adapter = new ReminderAdapter(getApplicationContext(), dataHolder);
        mRecyclerview.setAdapter(adapter);

        //Floating action button to create event
//        mCreateRem = (FloatingActionButton) findViewById(R.id.addRemBut);                     //Floating action button to change activity
//        mCreateRem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), createEvent.class);
//                startActivity(intent);                                                              //Starts the new activity to add Reminders
//            }
//        });
        //@sf ReminderActivity.class = class of event Card
        //@sf dbmanager is sqlite database class

    }

    @Override
    public void onBackPressed() {
        finish();                                                                                   //Makes the user to exit from the app
        super.onBackPressed();

    }
}
