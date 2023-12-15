package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UniversityAdapter adapter;
    private List<University> universities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        universities = new ArrayList<>();
        universities.add(new University("공과대학", "https://engineer.dongguk.edu", "0222603861", "woongsup@dongguk.edu", R.drawable.engineer));
        universities.add(new University("이과대학", "https://science.dongguk.edu", "0222603746", "woongsup@dongguk.edu", R.drawable.chemical));
        universities.add(new University("경찰사법대학", "https://justice.dongguk.edu", "0222603370", "policeadmin@dongguk.edu", R.drawable.police));
        universities.add(new University("경영대학", "https://sba.dongguk.edu", "0222608886", "woongsup@dongguk.edu", R.drawable.manage));
        universities.add(new University("바이오시스템대학", "https://life.dongguk.edu", "0319615103", "woongsup@dongguk.edu", R.drawable.bio));
        adapter = new UniversityAdapter(this, universities);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}