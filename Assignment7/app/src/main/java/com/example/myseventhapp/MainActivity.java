package com.example.myseventhapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);

        ArrayList<Schools> schoolsinfo = new ArrayList<>();
        schoolsinfo.add(new Schools(
                "동국대학교", R.drawable.dongguk, "https://www.dongguk.edu/"));
        schoolsinfo.add(new Schools(
                "고려대학교", R.drawable.korea, "https://www.korea.ac.kr/"));
        schoolsinfo.add(new Schools(
                "서울대학교", R.drawable.snu, "https://www.snu.ac.kr/"));

        MyAdapter myAdapter = new MyAdapter(schoolsinfo);
        myRecyclerView.setAdapter(myAdapter);
    }
}