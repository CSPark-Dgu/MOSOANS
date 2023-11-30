package com.example.myfifthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addStudent(View view) {
        //ContentValues 인스턴스를 만들고 원하는 값들을 put을 이용해 넣는다.
        ContentValues addValues = new ContentValues();
        addValues.put(MyContentProvider.NAME, ((EditText)findViewById(R.id.editText1)).getText().toString());
        addValues.put(MyContentProvider.STUDENT_ID, ((EditText)findViewById(R.id.editText2)).getText().toString());
        addValues.put(MyContentProvider.PHONE, ((EditText)findViewById(R.id.editText3)).getText().toString());
        getContentResolver().insert(MyContentProvider.CONTENT_URI, addValues);
        Toast.makeText(getBaseContext(), "New Student Record Inserted", Toast.LENGTH_LONG).show();
    }

    public void getStudents(View view) {
        String[] columns = new String[]{"_id", "student_id", "name", "phone_number"};
        Cursor c = getContentResolver().query(MyContentProvider.CONTENT_URI, columns, null, null, null);
        if(c!=null){
            EditText  editMultipleText =
                    findViewById(R.id.editText4);
            editMultipleText.setText("");
            while(c.moveToNext()){
                int id = c.getInt(0);
                String number = c.getString(1);
                String name = c.getString(2);
                String phone = c.getString(3);
                editMultipleText.append(id + " " + number + " " + name + " " + phone + "\n");
            }
            editMultipleText.append("\n Total : " + c.getCount());
            c.close();
        }
    }
}