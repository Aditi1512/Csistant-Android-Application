package com.example.csistant;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class login extends AppCompatActivity{

    private Button btnLogin;
    private EditText edtUsername;
    private EditText edtPassword;
    UserModel user;
    private DBHandler databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.button);
        edtUsername = (EditText) findViewById(R.id.usernameInput);
        edtPassword = (EditText) findViewById(R.id.passwordInput);

        databaseHelper = new DBHandler(login.this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View v) {
                boolean isExist = databaseHelper.checkUserExist(edtUsername.getText().toString(), edtPassword.getText().toString());

                if(isExist){
                    Toast.makeText(login.this,"Login Successful !", Toast.LENGTH_SHORT).show();
                    user = databaseHelper.fetchUserDetails(edtUsername.getText().toString(), edtPassword.getText().toString());
                    Intent intent = new Intent(login.this, homescreen.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                } else {
                    edtPassword.setText(null);
                    Toast.makeText(login.this, "Login failed. Invalid username or password.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}