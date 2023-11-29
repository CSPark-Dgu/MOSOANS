package com.example.myfourthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyReceiver br;
    String message = "Android App Message : ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(message, "On Create");

        br = new MyReceiver();

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("com.example.CUSTOM_INTENT");
        this.registerReceiver(br, filter); //시스템에 intent filter를 등록

    }

    public void broadcastIntent(View view){ //broadcast 메시지를 시스템에 보내는 메소드
        Intent intent = new Intent();
        intent.setAction("com.example.CUSTOM_INTENT");
        sendBroadcast(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(br); //시스템에 등록된 intent filter를 해제
    }
}