package com.example.mysecondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    String message = "Android App Message";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(message, "onCreate() operated!!");

        text = (TextView)findViewById(R.id.textView);
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(message, "onResume() operated!!");
        text = (TextView)findViewById(R.id.textView);
        text.setText("My onResume()!!");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(message, "onPause() operated!!");
        text = (TextView)findViewById(R.id.textView);
        text.setText("My onPause()!!");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(message, "onStop() operated!!");
        text = (TextView)findViewById(R.id.textView);
        text.setText("My onStop()!!");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(message, "onDestroy() operated!!");
        text = (TextView)findViewById(R.id.textView);
        text.setText("My onDestroy()!!");
    }

    //commit test 2
}