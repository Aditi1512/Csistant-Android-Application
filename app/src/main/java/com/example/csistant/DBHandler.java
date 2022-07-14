package com.example.csistant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class DBHandler extends SQLiteOpenHelper{

    private static final String DB_NAME = "csistant";
    private static final int DB_VERSION = 1;

    private static final String TABLE_USER = "user";
    private static final String EMAIL_ID = "id";
    private static final String NAME = "name";
    private static final String PHONE_NUMBER = "phoneNo";
    private static final String PASSWORD= "password";
    private static final String DOB = "dateOfBirth";

    private static final String TABLE_REMINDER = "reminder";
    private static final String R_NAME = "reminderName";
    private static final String R_DATE = "reminderDate";
    private static final String R_TIME = "reminderTime";
    private static final String MEETING_TYPE = "meetingType";
    private static final String MESSAGE = "message";


    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating an sqlite query and we are
        // setting our column name along with their data types.
        String query = "CREATE TABLE " + TABLE_USER + " ("
                + EMAIL_ID + " STRING PRIMARY KEY , "
                + NAME + " TEXT,"
                + PHONE_NUMBER + " LONG,"
                + PASSWORD + " TEXT,"
                + DOB + " TEXT)";

        String query2 = "CREATE TABLE " + TABLE_REMINDER + " ("
                + R_NAME + " STRING, "
                + R_DATE + " TEXT,"
                + R_TIME + " TEXT,"
                + MEETING_TYPE + " TEXT,"
                + MESSAGE + " TEXT)";
        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
        db.execSQL(query2);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewUser(String emailId, String name, long phoneNo, String pass, String dob ) {

        // creating a variable for our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        //creating a variable for content values.
        ContentValues values = new ContentValues();

        //passing all values along with its key and value pair.
        values.put(EMAIL_ID, emailId);
        values.put(NAME, name);
        values.put(PASSWORD, pass);
        values.put(PHONE_NUMBER, phoneNo);
        values.put(DOB, dob);

        // after adding all values we are passing content values to our table.
        db.insert(TABLE_USER, null, values);

        // closing database after adding.
        db.close();
    }

    public void addNewReminder(String rName, String rDate, String rTime, String meetingType, String message ) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(R_NAME, rName);
        values.put(R_DATE, rDate);
        values.put(R_TIME, rTime);
        values.put(MEETING_TYPE, meetingType);
        values.put(MESSAGE, message);

        db.insert(TABLE_REMINDER, null, values);

        db.close();
    }

    //@sf for reading all reminders in the homescreen recycler view ; called in homescreen class
    public Cursor readAllReminders() {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "SELECT * FROM " +TABLE_REMINDER+
                " ORDER BY " +R_TIME+ " DESC";                               //Sql query to  retrieve  data from the database
        Cursor cursor = database.rawQuery(query, null);
        return cursor;
    }


    public boolean checkUserExist(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {EMAIL_ID};
        String selection = EMAIL_ID +"=? AND " +PASSWORD+ "=?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);

        //boolean isExist = (cursor.getCount() > 0 );
        int count = cursor.getCount();
        cursor.close();
        if(count > 0){
            return true;
        }
        else {
            return false;
        }
        //cursor.close();
        //close();
        //return isExist;
    }

    public UserModel fetchUserDetails(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        UserModel details = new UserModel("dummy","dummy",0,"dummy","dummy");
        String[] columns = {EMAIL_ID};
        String selection = EMAIL_ID +"=? AND " +PASSWORD+ "=?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);

        if(cursor.moveToFirst())
        {
            Log.e("Sf","Inside DBHANDLER cursor");
            details = new UserModel("","",0,"","");
            details.setEmail_id(cursor.getString(1));
            details.setName(cursor.getString(2));
            details.setPassword(cursor.getString(4));
            details.setPhone_number(cursor.getLong(3));
            details.setDob(cursor.getString(5));
        }
        cursor.close();
        return details;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REMINDER);
        onCreate(db);
    }
}
