package com.example.tourism;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopDestinationAdapter extends RecyclerView.Adapter<TopDestinationAdapter.TopDestinationViewHolder> {

    Context context;
    List<TopDestination> topDestinationList;
    Fragment fragment;
    Bundle bundle;

    public TopDestinationAdapter(Context context, List<TopDestination> topDestinations){
        this.context = context;
        this.topDestinationList = topDestinations;
    }
    @NonNull
    @Override
    public TopDestinationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.top_destination, parent, false);

        return new TopDestinationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TopDestinationViewHolder holder, int position) {
        holder.imageView.setImageResource(topDestinationList.get(position).getImageId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                fragmentJump(topDestinationList.get(position));
            }
        });
    }

    private void fragmentJump(TopDestination itemSelected) {
        fragment = new DetailFragment();
//        bundle = new Bundle();
//        bundle.putParcelable("item_selected_key", (Parcelable) itemSelected);
//        fragment.setArguments(bundle);
        switchContent(R.layout.fragment_detail, fragment);
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
        return topDestinationList.size();
    }

    public class TopDestinationViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public TopDestinationViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.hori_image_id);
        }
    }
}
