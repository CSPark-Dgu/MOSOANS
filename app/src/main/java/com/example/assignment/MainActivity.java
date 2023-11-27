package com.example.assignment;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {   //콜백 함수

    public static final String EXTRA_MESSAGE = "com.example.assignment.MESSAGE"; //메시지를 전달하기 위한 키 값
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //기본 화면 구성
        setContentView(R.layout.activity_main); //추가 화면 구현
    }


    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextText);
        String message = editText.getText().toString(); //입력한 문자열을 가져옴
        intent.putExtra(EXTRA_MESSAGE, message); //intent에 message를 넣음
        startActivity(intent); //intent를 실행
    }


    @Override
    protected void onResume(){
        super.onResume();
        Log.d("MainActivity", "onResume 호출됨");
    }
}