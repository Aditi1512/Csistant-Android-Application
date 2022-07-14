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


public class signin extends AppCompatActivity {

    private EditText name, email, pass, confirmpass, phoneno, dob;
    //@sf add phoneno once text field for phn is created in ui  //done
    private Button signinButton;
    private DBHandler dbhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        name = findViewById(R.id.usernameInput);
        email = findViewById(R.id.emailInput);
        pass = findViewById(R.id.passwordInput);
        confirmpass = findViewById(R.id.confirmpasswordInput);
        phoneno = findViewById(R.id.phoneInput);
        dob = findViewById(R.id.dobInput);
        signinButton = findViewById(R.id.signinBut);

        dbhandler = new DBHandler(signin.this);

        signinButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View v) {

                String UserName = name.getText().toString();
                String Email = email.getText().toString();
                String Password = pass.getText().toString();
                String ConfirmPassword = confirmpass.getText().toString();
                long Phone = Long.parseLong(phoneno.getText().toString());
                String Dob = dob.getText().toString();

                if (UserName.isEmpty() && Email.isEmpty() && Phone == 0 && Password.isEmpty() && ConfirmPassword.isEmpty() && Dob.isEmpty()) {
                    Toast.makeText(signin.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!Password.equals(ConfirmPassword)) {
                    Toast.makeText(signin.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbhandler.addNewUser(Email, UserName, Phone, Password, Dob);

                Toast.makeText(signin.this, "Profile has been created.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(signin.this, homescreen.class);
                //intent.putExtra("username", edtUsername.getText().toString());
                startActivity(intent);
                name.setText("");
                email.setText("");
                pass.setText("");
                confirmpass.setText("");
                dob.setText("");
                phoneno.setText("");

            }
        });
    }
}