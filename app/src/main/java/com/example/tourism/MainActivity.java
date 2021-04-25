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
        int[] imageIdArray = {R.drawable.state_lib, R.drawable.art_gallery, R.drawable.box_hill_gardens};
        String[] nameArray = {"State Library", "Art Gallery", "Box Hill"};
        String[] descriptionArray = {"Located in Melbourne CBD", "Located in Melbourne CBD", "Located in Victoria"};

        PlaceToGo placeToGo;
        TopDestination topDestination;

        verti_recyclerView = findViewById(R.id.verti_rec_id);
        hori_recyclerView = findViewById(R.id.hori_rec_id);

        for (int i = 0; i < imageIdArray.length; i++){
            placeToGo = new PlaceToGo(imageIdArray[i], nameArray[i], descriptionArray[i]);
            placesToGoList.add(placeToGo);
        }
        for (int i = 0; i < imageIdArray.length; i++){
            topDestination = new TopDestination(imageIdArray[i]);
            topDestinationList.add(topDestination);
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