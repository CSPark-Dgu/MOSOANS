package com.example.myfifthapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentDBManager extends SQLiteOpenHelper {
    static final String Student_DB = "Students.db"; //database name
    static final String Student_TABLE = "Students"; //database table name
    Context context = null;
    private static StudentDBManager dbManager = null;

    //데이터베이스 표 생성 명령어
    static final String CREATE_DB =
            "CREATE TABLE IF NOT EXISTS " + Student_TABLE + "(" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "student_id TEXT NOT NULL, " +
                    "name TEXT NOT NULL, " +
                    "phone_number TEXT NOT NULL);";

    public static StudentDBManager getInstance(Context context){
        if(dbManager == null){
            dbManager = new StudentDBManager(context, Student_DB, null, 1);
        }
        return dbManager;
    }

    public StudentDBManager(Context context, String dbName, SQLiteDatabase.CursorFactory factory, int version){
        super(context, dbName, factory, version);
        this.context = context;
    }

    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + Student_TABLE);
        onCreate(db);
    }

    public long insert(ContentValues addValues){
        return getWritableDatabase().insert(Student_TABLE, null, addValues);
    }

    public Cursor query(String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy){
        return getReadableDatabase().query(Student_TABLE, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public int delete(String whereClause, String[] whereArgs){
        return getWritableDatabase().delete(Student_TABLE, whereClause, whereArgs);
    }
}
