package com.example.finalexam_2021;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText phoneEditText;
    private EditText emailEditText;
    private Button saveButton;
    private PersonDbHelper dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        emailEditText = findViewById(R.id.emailEditText);
        saveButton = findViewById(R.id.saveButton);

        dbManager = new PersonDbHelper(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String email = emailEditText.getText().toString();

                ContentValues values = new ContentValues();
                values.put(PersonDbHelper.COLUMN_NAME_NAME, name);
                values.put(PersonDbHelper.COLUMN_PHONE_PHONE, phone);
                values.put(PersonDbHelper.COLUMN_EMAIL_EMAIL, email);

                dbManager.insert(values);
                nameEditText.setText("");
                phoneEditText.setText("");
                emailEditText.setText("");

                // Start RecyclerViewActivity
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbManager.close();
    }
}