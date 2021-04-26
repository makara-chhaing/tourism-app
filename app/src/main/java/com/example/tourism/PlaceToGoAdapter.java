package com.example.tourism;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlaceToGoAdapter extends RecyclerView.Adapter<PlaceToGoAdapter.PlaceToGoViewHolder> {

    Context context;
    List<PlaceToGo> placesToGoList;
    Fragment fragment;
    Bundle bundle;

    public PlaceToGoAdapter(Context context, List<PlaceToGo> placesToGo){
        this.context = context;
        this.placesToGoList = placesToGo;
    }

    @NonNull
    @Override
    public PlaceToGoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.place_to_go_layout, parent, false);

        return new PlaceToGoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceToGoViewHolder holder, int position) {
        holder.imageView.setImageResource(placesToGoList.get(position).getImageId());
        holder.name.setText(placesToGoList.get(position).getName());
        holder.location.setText(placesToGoList.get(position).getLocation());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentJump(placesToGoList.get(position));
            }
        });
    }

    private void fragmentJump(PlaceToGo itemSelected) {
        fragment = new DetailFragment();
        bundle = new Bundle();
        bundle.putSerializable("place", itemSelected);
        fragment.setArguments(bundle);
        switchContent(R.id.main_id, fragment);
    }

    public void switchContent(int id, Fragment fragment) {
        if (context == null)
            return;
        if (context instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) context;
            this.fragment = fragment;
            mainActivity.switchContent(id, fragment);
        }

    }
    @Override
    public int getItemCount() {
        return placesToGoList.size();
    }

    public class PlaceToGoViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, location;
        public PlaceToGoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_id);
            name = itemView.findViewById(R.id.name_id);
            location = itemView.findViewById(R.id.location_id);
        }
    }
}
