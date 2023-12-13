package com.example.finalexam_2021;

import static com.example.finalexam_2021.PersonContract.PersonEntry.TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PersonDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Person.db";
    // ... other code ...

    public static final String COLUMN_NAME_NAME = "name";
    public static final String COLUMN_EMAIL_EMAIL = "email";
    public static final String COLUMN_PHONE_PHONE = "phone";
    // ... other code ...


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    PersonContract.PersonEntry._ID + " INTEGER PRIMARY KEY," +
                    PersonContract.PersonEntry.COLUMN_NAME_NAME + " TEXT," +
                    PersonContract.PersonEntry.COLUMN_NAME_PHONE + " TEXT," +
                    PersonContract.PersonEntry.COLUMN_NAME_EMAIL + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public PersonDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public long insert(ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        return db.insert(TABLE_NAME, null, values);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}