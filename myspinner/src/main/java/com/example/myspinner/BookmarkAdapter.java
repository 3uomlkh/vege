package com.example.myspinner;

import android.content.Context;
import android.util.Log;
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
import java.util.List;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.ViewHolder>{
    private Context context;
    private List<Data> dataList;

    public BookmarkAdapter(Context context, List<Data> dataList) {
        this.context = context;
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public BookmarkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.bookmark1_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.onBind(dataList.get(position));
        holder.name.setText(dataList.get(position).getName());
        holder.address.setText("" + dataList.get(position).getAddress());

    }

    @Override
    public int getItemCount() {

        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView address;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.bookmarkNameTv);
            address = (TextView)itemView.findViewById(R.id.bookmarkAddrTv);
            image = (ImageView)itemView.findViewById(R.id.bookmarkImageView);
        }
//        public void onBind(Data dataList) {
//            name.setText(dataList.getClass().getName());
//            address.setText(dataList.toString());
//            String imgURL= dataList.getImage();
//            Glide.with(itemView)
//                    .load(imgURL)
//                    .override(300,400)
//                    .apply(new RequestOptions().transform(new CenterCrop(),
//                            new RoundedCorners(20)))
//                    .into(imageView);
//        }
    }



//    ArrayList<Restaurant> items = new ArrayList<Restaurant>();
//    private OnItemClickListener itemClickListener;
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View itemView = inflater.inflate(R.layout.bookmark1_item, parent, false);
//
//        return new ViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.onBind(items.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return items.size();
//    }
//
//    public void addItem(Restaurant item) {
//        items.add(item);
//    }
//
//    public interface OnItemClickListener{
//        void onItemClick(View view, int pos);
//        //void onFavoriteClick(View view, int pos);
//    }
//
//    public void setOnItemClickListener(OnItemClickListener listener){
//        this.itemClickListener = listener;
//    }
//
//    class ViewHolder extends RecyclerView.ViewHolder {
//        private TextView nameTv;
//        private TextView addrTv;
//        private ImageView imageView;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            nameTv = itemView.findViewById(R.id.bookmarkNameTv);
//            addrTv = itemView.findViewById(R.id.bookmarkAddrTv);
//            imageView = itemView.findViewById(R.id.bookmarkImageView);
//            Context context = itemView.getContext();
//
//            //itemView.setClickable(true);
//            itemView.getRootView().setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    int pos = getAdapterPosition();
//                    if(pos != RecyclerView.NO_POSITION){
////                        Intent intent = new Intent(context, ItemDetailActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                        intent.putExtra("Image", itemView.);
////                        context.startActivities(intent);
//                        if(itemClickListener != null){
//                            itemClickListener.onItemClick(itemView, pos);
//                        }
//                    }
//                }
//            });
//        }
//        public void onBind(Restaurant item) {
//            nameTv.setText(item.getName());
//            addrTv.setText(item.getAddress());
//            String imgURL= item.getImage();
//            Glide.with(itemView)
//                    .load(imgURL)
//                    .override(300,400)
//                    .apply(new RequestOptions().transform(new CenterCrop(),
//                            new RoundedCorners(20)))
//                    .into(imageView);
//        }
//    }
}