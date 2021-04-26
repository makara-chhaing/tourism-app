package com.example.tourism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<PlaceToGo> placesToGoList = new ArrayList<>();
    RecyclerView verti_recyclerView, hori_recyclerView;
    List<TopDestination> topDestinationList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] imageIdArray = {R.drawable.state_lib, R.drawable.art_gallery, R.drawable.dandenong, R.drawable.box_hill_gardens, R.drawable.phillip_island};
        String[] nameArray = {"State Library", "Art Gallery", "Dandenong Range", "Box Hill", "Phillip Island"};
        String[] descriptionArray = {"A quiet library in the heart of Melbourne City.", "The place that display art from over the world.",
                "A very nice range full of trees and wildlife", "A suburb that is lively and beautiful.",  "A beautiful island that has a breathtaking view and penguin Located in Victoria"};
        String[] locationArray = {"Located in Melbourne CBD", "Located in Melbourne CBD", "Located in Victoria",
                "Located in Victoria", "Located in Victoria"};

        PlaceToGo placeToGo;
        TopDestination topDestination;

        verti_recyclerView = findViewById(R.id.verti_rec_id);
        hori_recyclerView = findViewById(R.id.hori_rec_id);

        for (int i = 0; i < imageIdArray.length; i++){
            placeToGo = new PlaceToGo(imageIdArray[i], nameArray[i], locationArray[i], descriptionArray[i]);
            placesToGoList.add(placeToGo);
            if(i%2==0){
                topDestination = new TopDestination(imageIdArray[i], placeToGo);
                topDestinationList.add(topDestination);
            }
        }
        // Add adapter for vertical recyclerview (Top Destination)
        PlaceToGoAdapter placeToGoAdapter = new PlaceToGoAdapter(MainActivity.this, placesToGoList);
        verti_recyclerView.setAdapter(placeToGoAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        verti_recyclerView.setLayoutManager(layoutManager);

        // Set Adapter and LayoutManager for horizontal recyclerView (Places to go)
        TopDestinationAdapter adapter = new TopDestinationAdapter(MainActivity.this, topDestinationList);
        hori_recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager hor_layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false);
        hori_recyclerView.setLayoutManager(hor_layoutManager);


    }

    public void switchContent(int id, Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment, fragment.toString());
        ft.addToBackStack(null);
        ft.commit();
    }
}