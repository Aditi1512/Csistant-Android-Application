package com.example.csistant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

public class MainActivity extends AppCompatActivity {

    public void gotoLoginPage(View view)
    {
        Intent intent = new Intent(this,login.class);
        startActivity(intent);
    }
    public void gotoSignUpPage(View view)
    {
        Intent intent = new Intent(this,signin.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

