package com.example.finalexam_2021;

import android.database.Cursor;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PersonAdapter adapter;
    private PersonDbHelper dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbManager = new PersonDbHelper(this);
        Cursor cursor = dbManager.getReadableDatabase().query(PersonContract.PersonEntry.TABLE_NAME, null, null, null, null, null, null);

        adapter = new PersonAdapter(this, cursor);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbManager.close();
    }
}