package com.example.tourism;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
    ImageView image;
    TextView name, location, description;
    static PlaceToGo place;

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("place", place);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        place = (PlaceToGo) getArguments().getSerializable("place");
        image = (ImageView) view.findViewById(R.id.image_frag_id);
        name = (TextView) view.findViewById(R.id.name_frag_id);
        location = (TextView) view.findViewById(R.id.location_frag_id);
        description = (TextView) view.findViewById(R.id.description_frag_id);
        if(place != null){
            image.setImageResource(place.getImageId());
            if(image != null){
                image.setImageResource(place.getImageId());
            }
            if(name != null){
                name.setText(place.getName());
            }
            if(location != null){
                location.setText(place.getLocation());
            }
            if (description !=null) {
                description.setText(place.getDescription());
            }
        }
        return view;
    }
}