package com.example.csistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;
import android.app.Activity;

import android.os.Bundle;

public class EditEvent extends AppCompatActivity {
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_event);

        Spinner spinner = (Spinner) findViewById(R.id.meeting_type);
        Spinner spinner1 = (Spinner) findViewById(R.id.message_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.meeting_type, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.message_spinner, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter1);
    }
    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
            Spinner spinner = (Spinner) findViewById(R.id.meeting_type);
            spinner.setOnItemSelectedListener(this);
            Spinner spinner1 = (Spinner) findViewById(R.id.message_spinner);
            spinner.setOnItemSelectedListener(this);
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
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
    public void gotoEditEvent(View view) {
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
    }
}
