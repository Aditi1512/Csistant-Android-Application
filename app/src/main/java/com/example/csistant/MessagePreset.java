package com.example.csistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MessagePreset extends AppCompatActivity {
    //    EditText message;
    String phoneNumber;
    Button sendButton;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_preset);
        sendButton = (Button) findViewById(R.id.button4);
        phoneNumber = "8707068217";
//        message=findViewById(R.id.radioGroup);
        sendButton.setOnClickListener(new View.OnClickListener() {

            Intent intent = null;

            public void onClick(View view) {
                String number = phoneNumber;
                String msg = message.toString();
                try {
//                    SmsManager smsManager = SmsManager.getDefault();
//                    smsManager.sendTextMessage(number, null, msg, null, null);
                    Timer timer = setTimerForSendingMsg(phoneNumber, msg);
                    Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_LONG).show();

                    intent = new Intent(MessagePreset.this, createEvent.class);

                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Some fields is Empty", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
    public void onRadioButtonClicked (View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButton6:

//                Intent intent = null;
                if (checked) {
                    message = "I'll join you in 10-15 minutes";
//                    intent = new Intent(messagePreset.this, createEvent.class);
//                    intent.putExtra("message", msg);
//                    startActivity(intent);
                    break;
                }
            case R.id.radioButton7:
                if (checked) {
                    message = "If possible, please reschedule";
//                    intent = new Intent(messagePreset.this, createEvent.class);
//                    startActivity(intent);
                    break;
                }
            case R.id.radioButton8:
                if (checked) {
                    message = "Please manage the meeting on my behalf";
//                    intent = new Intent(messagePreset.this, createEvent.class);
//                    startActivity(intent);
                    break;
                }
            case R.id.radioButton9:
                if (checked) {
                    message = "Sorry, I am unable to join";
//                    intent = new Intent(messagePreset.this, createEvent.class);
//                    startActivity(intent);
                    break;
                }
            case R.id.radioButton10:
                if (checked) {
                    message = "please postpone today's meet";
//                    intent = new Intent(messagePreset.this, createEvent.class);
//                    startActivity(intent);
                    break;
                }
            case R.id.radioButton11:
                if (checked) {
                    message = "I need some more time to prepare the proposal";
//                    intent = new Intent(messagePreset.this, createEvent.class);
//                    startActivity(intent);
                    break;
                }
            case R.id.radioButton12:
                if (checked) {
                    message = "I've shared the proposal please go through it";
//                    intent = new Intent(messagePreset.this, createEvent.class);
//                    startActivity(intent);
                    break;
                }
//            case R.id.radioButton13:
//                if (checked) {
//                    intent = new Intent(messagePreset.this, createEvent.class);
//                    startActivity(intent);
//                    break;
//                }
//            case R.id.radioButton14:
//                if (checked) {
//                    intent = new Intent(messagePreset.this, createEvent.class);
//                    startActivity(intent);
//                    break;
//                }
//            case R.id.radioButton15:
//                if (checked) {
//                    intent = new Intent(messagePreset.this, createEvent.class);
//                    startActivity(intent);
//                    break;
//                }
        }
    }

    private  static Timer setTimerForSendingMsg(String number, String mssg){

        TimerTask task = new TimerTask(){
            @Override
            public void run(){
                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(number,null,mssg,null,null);

            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 60000L, 180000L);
        return  timer;
    }
}