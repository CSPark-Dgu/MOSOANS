package com.example.finalexam_2021;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PeopleDBManager extends SQLiteOpenHelper{

        private static final String DATABASE_NAME = "people.db";
        private static final int DATABASE_VERSION = 1;
        private static final String TABLE_NAME = "people";
        private static final String COLUMN_ID = "_id";
        private static final String COLUMN_NAME = "name";
        private static final String COLUMN_EMAIL = "email";
        private static final String COLUMN_PHONE = "phone";

        Context context;

        public PeopleDBManager(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_PHONE + " TEXT);";
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String sql = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
            db.execSQL(sql);
            onCreate(db);
        }

        public long insert(ContentValues values){
            SQLiteDatabase db = getWritableDatabase();
            long id = db.insert(TABLE_NAME, null, values);
            db.close();
            return id;
        }

        public Cursor query(String[] projection, String selection, String[] selectionArgs, String sortOrder){
            SQLiteDatabase db = getReadableDatabase();
            return db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
        }

        public int delete(String selection, String[] selectionArgs){
            SQLiteDatabase db = getWritableDatabase();
            int count = db.delete(TABLE_NAME, selection, selectionArgs);
            db.close();
            return count;
        }

}
