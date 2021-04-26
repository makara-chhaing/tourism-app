package com.example.tourism;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlaceToGoAdapter extends RecyclerView.Adapter<PlaceToGoAdapter.PlaceToGoViewHolder> {

    Context context;
    List<PlaceToGo> placesToGo;

    public PlaceToGoAdapter(Context context, List<PlaceToGo> placesToGo){
        this.context = context;
        this.placesToGo = placesToGo;
    }

    @NonNull
    @Override
    public PlaceToGoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.place_to_go_layout, parent, false);

        return new PlaceToGoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceToGoViewHolder holder, int position) {
        holder.imageView.setImageResource(placesToGo.get(position).getImageId());
        holder.name.setText(placesToGo.get(position).getName());
        holder.description.setText(placesToGo.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return placesToGo.size();
    }

    public class PlaceToGoViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, description;
        public PlaceToGoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_id);
            name = itemView.findViewById(R.id.name_id);
            description = itemView.findViewById(R.id.location_id);
        }
    }
}
