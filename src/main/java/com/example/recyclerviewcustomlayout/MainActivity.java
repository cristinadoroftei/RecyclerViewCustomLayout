package com.example.recyclerviewcustomlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int[] iconList = {R.drawable.cupcake, R.drawable.donut, R.drawable.eclair, R.drawable.froyo, R.drawable.gingerbread};

    String[] namesList = {"Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread"};

    String[] datesList = {"April 27, 2009", "September 15, 2009", "October 26, 2009", "May 20, 2010", "December 6, 2010"};

    RecyclerView recyclerView;
    AndroidVersionAdapter androidVersionAdapter;
    List<AndroidVersion> androidVersionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        androidVersionAdapter = new AndroidVersionAdapter(androidVersionList, MainActivity.this);
        //the layout manager for the recycler view will help us to make the recycler view horizontal or vertical
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        //link the recycler view to the adapter
        recyclerView.setAdapter(androidVersionAdapter);

        //Filling our recycler view list
        for (int i=0; i<iconList.length; i++){
            String name = namesList[i];
            String date = datesList[i];
            int icon = iconList[i];


            AndroidVersion androidVersion = new AndroidVersion(i, icon, date, name);
            androidVersionList.add(androidVersion);

        }
    }
}
