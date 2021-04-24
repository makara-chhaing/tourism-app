package com.example.tourism;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopDestinationAdapter extends RecyclerView.Adapter<TopDestinationAdapter.TopDestinationViewHolder> {

    Context context;
    List<TopDestination> topDestinationList;

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

            }
        });
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
