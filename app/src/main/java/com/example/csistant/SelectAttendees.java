package com.example.csistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectAttendees extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ContactModel> arrayList = new ArrayList<ContactModel>();
    MainAdapter adapter;


    public void gotoCreateEvent(View view) {
        Intent intent = new Intent(this, createEvent.class);
        long num = getIntent().getLongExtra("attendee_contact",0);
        intent.putExtra("attendee_contact", num);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_attendees);


        // assign variable
        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // initialize adapter
        adapter = new MainAdapter(arrayList, getApplicationContext());
        recyclerView.setAdapter(adapter);



        // check permission
        checkPermission();
    }

    private void checkPermission() {

        // check condition

        if(ContextCompat.checkSelfPermission(SelectAttendees.this,
                Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){

            // when permission is not granted
            // request permission
            ActivityCompat.requestPermissions(SelectAttendees.this,
                    new String[] {Manifest.permission.READ_CONTACTS}, 100);
        }
        else{
            // when permission is granted
            // create method

            getContactList();

        }
    }

    private void getContactList() {


        // initialize uri

        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        // sort by ascending
        String sort = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;
        // initialize cursor
        Cursor cursor = getContentResolver().query(uri, null, null ,
                null, sort);

        // check condition
        if(cursor.getCount() > 0){
            // when count is greater than zero use while loop
            while(cursor.moveToNext()){
                // cursor move to next
                // get Contact id

                @SuppressLint("Range")
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));

                // get contact name
                @SuppressLint("Range")
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                // initialize phone uri
                Uri uriPhone = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

                // initialize selection
                String selection = ContactsContract.CommonDataKinds.Phone.CONTACT_ID+" = ?";

                // initialize phone cursor
                Cursor phoneCursor = getContentResolver().query(uriPhone, null,
                        selection, new String[] {id}, null);

                // check condition
                if(phoneCursor.moveToNext()){
                    // when phone cursor move to next
                    @SuppressLint("Range") String number = phoneCursor.getString(phoneCursor.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER));
                    // initialize contact model
                    ContactModel model = new ContactModel();
                    model.setName(name);
                    model.setNumber(number);
                    arrayList.add(model);
                    phoneCursor.close();
                }

            }

            cursor.close();

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // check condition
        if(requestCode == 100 && grantResults.length > 0 &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED){
            // when permission is granted, call method
            getContactList();
        }
        else{
            // when permission is denied
            Toast.makeText(SelectAttendees.this, "Permission Denied",
                    Toast.LENGTH_SHORT).show();

            // call check permission
            checkPermission();
        }
    }

    public void gotoProfilePage(View view) {
        Intent intent = new Intent(this,ProfilePage.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }
}