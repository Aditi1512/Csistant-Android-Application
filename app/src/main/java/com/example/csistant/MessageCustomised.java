package com.example.csistant;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MessageCustomised extends AppCompatActivity {
    EditText message;
    String phoneNumber;
    Button sendButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_customised);
        sendButton = (Button)findViewById(R.id.button);
        phoneNumber ="6386264837";
        message=findViewById(R.id.editText2);
        sendButton.setOnClickListener(new View.OnClickListener() {

            Intent intent = null;
            public void onClick(View view) {
                String number= phoneNumber;
                String msg=message.getText().toString();
                try {

                    Timer timer = setTimerForSendingMsg(phoneNumber, msg);
                    intent = new Intent(MessageCustomised.this, createEvent.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Message Sent",Toast.LENGTH_LONG).show();
//                    timer.cancel();
//                    timer.purge();

                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Some fields is Empty",Toast.LENGTH_LONG).show();
                }
//                finally {
//                    setTimerForSendingMsg(phoneNumber,msg).cancel();
//                }


            }
        });
    }

    private  static Timer setTimerForSendingMsg(String number,String mssg){

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