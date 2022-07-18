package com.example.restaurant_list;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

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

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                nameTv = itemView.findViewById(R.id.nameTv);
                addrTv = itemView.findViewById(R.id.addrTv);
                imageView = itemView.findViewById(R.id.imageView);
        }
            public void onBind(Rest item) {
                nameTv.setText(item.getName());
                addrTv.setText(item.getAddress());
                String imgURL= item.getImage();
                Glide.with(itemView)
                        .load(imgURL)
                        .override(300,400)
                        .apply(new RequestOptions().transform(new CenterCrop(),
                                new RoundedCorners(20)))
                        .into(imageView);
            }

    }
}
