package com.example.finalexam_2022;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        ListView listView = findViewById(R.id.list_view);
        String[] items = new String[]{"신공학관", "공대학사운영실", "기숙사"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mapUri = "https://www.google.com/maps/search/?api=1&query=";
                switch (position) {
                    case 0:
                        mapUri += Uri.encode("37.558058787929134,126.99840306484138");
                        break;
                    case 1:
                        mapUri += Uri.encode("37.5589262868377,126.99889548582202");
                        break;
                    case 2:
                        mapUri += Uri.encode("37.558402166228966,126.99814771755447");
                        break;
                }
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapUri));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}