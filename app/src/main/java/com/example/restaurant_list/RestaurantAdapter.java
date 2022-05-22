package com.example.restaurant_list;
import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {
        ArrayList<Rest> items = new ArrayList<Rest>();

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.item, parent, false);

            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.onBind(items.get(position));
            /*ViewHolder vh = (ViewHolder) holder;

            Rest item = items.get(position);
            vh.setItem(item);
            *//*vh.nameTv.setText(item.name);
            vh.addrTv.setText(item.address);

            Glide.with(context).load(item.image).into(vh.imageView);*/
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public void addItem(Rest item) {
        items.add(item);
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private TextView nameTv;
            private TextView addrTv;
            private ImageView imageView;
            private String imgURL;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                nameTv = itemView.findViewById(R.id.nameTv);
                addrTv = itemView.findViewById(R.id.addrTv);
                imageView = itemView.findViewById(R.id.imageView);
        }
            public void onBind(Rest item) {
                nameTv.setText(item.name);
                addrTv.setText(item.address);
                String imgURL= item.getImage();
                Glide.with(itemView).load(imgURL).into(imageView);
            }

    }
}
