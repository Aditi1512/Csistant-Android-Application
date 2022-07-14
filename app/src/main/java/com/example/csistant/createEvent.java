//package com.example.csistant;
//
//import androidx.annotation.RequiresApi;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.DialogFragment;
////import android.support.v7.app.AppCompatActivity;
//import android.app.AlarmManager;
//import android.app.PendingIntent;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Build;
//import android.os.Bundle;
//import android.os.Handler;
//import android.text.format.DateFormat;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Spinner;
//import android.widget.AdapterView.OnItemSelectedListener;
//import android.widget.Toast;
//import android.app.Activity;
//
//import android.os.Bundle;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///*TODO : either add description field to reminder table or remove from create event ui */
//
//public class createEvent extends AppCompatActivity {
//
////private String rName, rTime, rDate;
////private String mType, message;
//
//private EditText rn, rt, rd;
//
//private Button createButton;
//private Button selAttendees;
//private DBHandler dbhandler;
//
//
//public void showTimePickerDialog(View v) {
//    DialogFragment newFragment = new TimePickerFragment();
//    newFragment.show(getSupportFragmentManager(), "timePicker");
//}
//public void showDatePickerDialog(View v) {
//    DialogFragment newFragment = new DatePickerFragment();
//    newFragment.show(getSupportFragmentManager(), "datePicker");
//}
//@Override
//protected void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    setContentView(R.layout.activity_create_event);
//
////    selAttendees = findViewById(R.id.selectattendeesBut);
////    rName = ((EditText) findViewById(R.id.eventnameInput)).getText().toString();
////    rTime = ((EditText) findViewById(R.id.eventtimeInput)).getText().toString();
////    rDate = ((EditText) findViewById(R.id.eventdateInput)).getText().toString();
////    ((EditText) findViewById(R.id.eventdateInput)).setText(rDate);
//
//    rn = findViewById(R.id.eventnameInput);
//    rt = findViewById(R.id.eventtimeInput);
//    rd = findViewById(R.id.eventdateInput);
//
//    //mType = ((Spinner) findViewById(R.id.meeting_type)).getSelectedItem().toString();
//    Spinner s = findViewById(R.id.meeting_type);
//    Spinner spinner = (Spinner) findViewById(R.id.meeting_type);
//    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.meeting_type, android.R.layout.simple_spinner_item);
//    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//    spinner.setAdapter(adapter);
//    //mType = s.getSelectedItem().toString();
//
//    //message = ((Spinner) findViewById(R.id.message_spinner)).getSelectedItem().toString();
//    Spinner s1 = findViewById(R.id.message_spinner);
//    Spinner spinner1 = (Spinner) findViewById(R.id.message_spinner);
//    ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.message_spinner, android.R.layout.simple_spinner_item);
//    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//    spinner1.setAdapter(adapter1);
//    //message = s1.getSelectedItem().toString();
//
//    createButton = findViewById(R.id.createBut);
//
//    dbhandler = new DBHandler(createEvent.this);
//
//
//
//    createButton.setOnClickListener(new View.OnClickListener() {
//
//        @RequiresApi(api = Build.VERSION_CODES.M)
//        @Override
//        public void onClick(View v) {
//
//            String rName = rn.getText().toString();
//            String rTime = rt.getText().toString();
//            String rDate = rd.getText().toString();
//            String mType = s.getSelectedItem().toString();
//            String message = s1.getSelectedItem().toString();
//
//            if (rName.isEmpty()) {
//                Toast.makeText(getApplicationContext(), "Please Enter text", Toast.LENGTH_SHORT).show();
//            }
//            else {
//                if (rTime.equals("time") || rDate.equals("date")) {
//                    Toast.makeText(getApplicationContext(), "Please select date and time", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    processInsert(rName, rDate, rTime, mType, message);
//                }
//            }
//        }
//    });
//
////    selAttendees.setOnClickListener(new View.OnClickListener() {
////        @Override
////        public void onClick(View v) {
////            selectAttendeesActivity();
////        }
////    });
//
//}
//
////public void selectAttendeesActivity(){
////        Intent intent = new Intent(this, SelectAttendees.class);
////        startActivity(intent);
////}
//
//
//@RequiresApi(api = Build.VERSION_CODES.M)
//public void processInsert(String rName, String rDate, String rTime, String mType, String message) {
//    new DBHandler(this).addNewReminder(rName, rDate, rTime, mType, message);
//    setAlarm(rName, rDate, rTime);
//    Toast.makeText(createEvent.this, "Reminder Added", Toast.LENGTH_SHORT).show();
//}
//
//@RequiresApi(api = Build.VERSION_CODES.M)
//private void setAlarm(String text, String date, String time) {
//
//    AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);             //assigning alarm manager object to set alarm
//    Intent intent = new Intent(getApplicationContext(), AlarmBroadcast.class);
//    intent.putExtra("event", text);                                                       //sending data to alarm class to create channel and notification
//    intent.putExtra("time", date);
//    intent.putExtra("date", time);
//    PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
//    String dateandtime = date + " " + TimePickerFragment.resultTime;
//    SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy hh:mm a");
//    final Handler handler = new Handler();
//
//    try {
//        Date date1 = formatter.parse(dateandtime);
//        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, date1.getTime(), pendingIntent);
////        Toast.makeText(getApplicationContext(), "Alarm created", Toast.LENGTH_SHORT).show();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(createEvent.this,"Alarm created",Toast.LENGTH_LONG).show();
//
//            }}, 20000);
//
//    }
//
//    catch (ParseException e) {
//        e.printStackTrace();
//    }
//    Intent intentBack = new Intent(this, createEvent.class);                //this intent will be called once the setting alarm is complete
//    intentBack.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//    startActivity(intentBack);                                                                  //navigates from adding reminder activity to mainactivity
//}
//
//public class SpinnerActivity extends Activity implements OnItemSelectedListener {
//
//    public void onItemSelected(AdapterView<?> parent, View view,
//                               int pos, long id) {
//        Spinner spinner = (Spinner) findViewById(R.id.meeting_type);
//        spinner.setOnItemSelectedListener(this);
//        Spinner spinner1 = (Spinner) findViewById(R.id.message_spinner);
//        spinner.setOnItemSelectedListener(this);
//    }
//
//    public void onNothingSelected(AdapterView<?> parent) {
//        // Another interface callback
//    }
//}
//}


package com.example.csistant;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
//import android.support.v7.app.AppCompatActivity;

public class createEvent extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    private static final String TAG= "SF:" ;
    DBHandler dbHandler;
    private String rName, rTime, rDate;
    private String mType, message;

    Button buttonTime, buttonDate, selAttendees, createButton;
    //Button buttonTime = (Button) findViewById(R.id.eventtimeInput);
    //Button buttonDate = (Button) findViewById(R.id.eventdateInput);
    EditText eName;
    //Button createButton = findViewById(R.id.createBut);

    Calendar c = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

//        rName = eName.getText().toString();
        eName = (EditText) findViewById(R.id.eventnameInput);

        Spinner s = findViewById(R.id.meeting_type);
        Spinner spinner = (Spinner) findViewById(R.id.meeting_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.meeting_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Log.e(TAG,"spinner 1");
//        mType =  s.getSelectedItem().toString();

        Spinner s1 = findViewById(R.id.message_spinner);
        Spinner spinner1 = (Spinner) findViewById(R.id.message_spinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.message_spinner, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        Log.e(TAG,"spinner 2");
//        message =  s1.getSelectedItem().toString();

        buttonTime = (Button) findViewById(R.id.eventtimeInput);
        buttonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
                Log.e(TAG,"on click of time button ");
            }
        });

        buttonDate = (Button) findViewById(R.id.eventdateInput);
        buttonDate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
                Log.e(TAG,"on click of date button ");
            }
        });

        selAttendees = findViewById(R.id.selectattendeesBut);
        selAttendees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectAttendees.class);
                startActivity(intent);
                Log.e(TAG,"on click of selateendees button ");
            }
        });


        createButton = (Button) findViewById(R.id.createBut);
        createButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                Log.e(TAG,"on click of create button ");

            rName = eName.getText().toString();
            mType =  s.getSelectedItem().toString();
            message =  s1.getSelectedItem().toString();

            if (rName.isEmpty()) {
                Log.e(TAG,"inside name toast");
                Toast.makeText(getApplicationContext(), "Please Enter text", Toast.LENGTH_SHORT).show();
            }
            else {
                if (rTime.equals("time") || rDate.equals("date")) {
                    Log.e(TAG,"inside time toast");
                    Toast.makeText(getApplicationContext(), "Please select date and time", Toast.LENGTH_SHORT).show();
                }
                else {
//                    processInsert(rName, rDate, rTime, mType, message);

                    new DBHandler(getApplicationContext()).addNewReminder(rName, rDate, rTime, mType, message);
                    setAlarm(rName, rDate, rTime);
                    Log.e(TAG,"inside adding reminder toast");
                    Toast.makeText(createEvent.this, "Reminder Added", Toast.LENGTH_SHORT).show();
                }
            }

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void setAlarm(String text, String date, String time) {

        long x = c.getTimeInMillis();
        Log.e(TAG,"inside Set Alarm "+x);
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);             //assigning alarm manager object to set alarm
        Intent intent = new Intent(getApplicationContext(), AlarmBroadcast.class);
        intent.putExtra("event", text);                                                 //sending data to alarm class to create channel and notification
        intent.putExtra("time", date);
        intent.putExtra("date", time);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_ONE_SHOT);
        if (c.before(Calendar.getInstance())) {
                c.add(Calendar.DATE, 1);
            }
        am.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
        Toast.makeText(getApplicationContext(), "Alarm created", Toast.LENGTH_SHORT).show();

        Intent intentBack = new Intent(this, homescreen.class);                //this intent will be called once the setting alarm is complete
        intentBack.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intentBack);  //navigates from adding reminder activity to mainactivity
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Log.e(TAG,"inside onTimeSet toast");
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);
        rTime = hourOfDay + ":" + minute;
        //buttonTime.setText(hourOfDay + ":" + minute);
        buttonTime.setText(rTime);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int date) {
        Log.e(TAG,"inside onDateSet toast");
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.YEAR, year);
        c1.set(Calendar.MONTH, month);
        c1.set(Calendar.DAY_OF_MONTH, date);

        SimpleDateFormat d =  new SimpleDateFormat();
        String currentDateString = (String) d.format(c1.getTime());

        rDate = currentDateString;
        buttonDate.setText(currentDateString);
    }

    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        Spinner spinner = (Spinner) findViewById(R.id.meeting_type);
        spinner.setOnItemSelectedListener(this);
        Spinner spinner1 = (Spinner) findViewById(R.id.message_spinner);
        spinner.setOnItemSelectedListener(this);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
}