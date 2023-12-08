package com.example.finalexam_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addPerson(View view){
        ContentValues values = new ContentValues();
        values.put(MyContentProvider.NAME, ((EditText)findViewById(R.id.text_name)).getText().toString());
        values.put(MyContentProvider.EMAIL, ((EditText)findViewById(R.id.text_email)).getText().toString());
        values.put(MyContentProvider.PHONE, ((EditText)findViewById(R.id.text_phone)).getText().toString());
        getContentResolver().insert(MyContentProvider.CONTENT_URI, values);
        Toast.makeText(this, "Person added", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ShowPeople.class);
        startActivity(intent);
    }

}