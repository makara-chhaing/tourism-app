package com.example.tourism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<PlaceToGo> placesToGoList = new ArrayList<>();
    RecyclerView verti_recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] imageIdArray = {};
        String[] nameArray = {"State Library", "Art Gallery", "Box Hill"};
        String[] descriptionArray = {"Located in Melbourne CBD", "Located in Melbourne CBD", "Located in Victoria"};

        PlaceToGo placeToGo;

        verti_recyclerView = findViewById(R.id.verti_rec_id);

        for (int i = 0; i < imageIdArray.length; i++){
            placeToGo = new PlaceToGo(imageIdArray[i], nameArray[i], descriptionArray[i]);
            placesToGoList.add(placeToGo);
        }

        PlaceToGoAdapter placeToGoAdapter = new PlaceToGoAdapter(MainActivity.this, placesToGoList);
        verti_recyclerView.setAdapter(placeToGoAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        verti_recyclerView.setLayoutManager(layoutManager);
    }
}