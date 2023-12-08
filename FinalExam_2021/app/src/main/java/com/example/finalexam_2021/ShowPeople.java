package com.example.finalexam_2021;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ShowPeople extends AppCompatActivity {

    private Adapter peopleAdapter;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_people);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Query the content provider for people data
        Cursor cursor = getContentResolver().query(MyContentProvider.CONTENT_URI, null, null, null, null);

        // Initialize the adapter with the cursor
        peopleAdapter = new Adapter(cursor);
        recyclerView.setAdapter(peopleAdapter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (peopleAdapter != null) {
            peopleAdapter.swapCursor(null);
        }
    }
}
