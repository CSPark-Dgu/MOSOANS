package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("MainActivity", "onPause 호출됨");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart 호출됨");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("MainActivity", "onResume 호출됨");
    }
}