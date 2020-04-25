package com.gahlot.indeetv.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.gahlot.indeetv.R;
import com.gahlot.indeetv.model.TestDataDTO;
import com.gahlot.indeetv.utils.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private static final String TAG = "CustomAdapter";

    private List<TestDataDTO> mData = new ArrayList<>();
    private Context context;
    private Utils utils = new Utils();

    public CustomAdapter(List<TestDataDTO> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    public void setData(List<TestDataDTO> data){
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.ItemName.setText(mData.get(position).getName());
        holder.ItemPlan.setText(mData.get(position).getPaymentPlan());
        holder.ItemReleaseDate.setText(utils.getSimplifiedDate(mData.get(position).getReleaseYear()));
        holder.ItemDuration.setText(mData.get(position).getVideoDuration());
        holder.ItemType.setText(mData.get(position).getType());
        holder.ItemCreatedOn.setText(utils.getSimplifiedDate(mData.get(position).getCreatedOn()));
        holder.ItemUpdatedOn.setText(utils.getSimplifiedDate(mData.get(position).getUpdatedOn()));
        holder.ItemShortDescription.setText(mData.get(position).getShortDescription());
        holder.ItemDescription.setText(mData.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ItemImage;
        TextView ItemName,ItemPlan,ItemReleaseDate,ItemDuration,ItemType,ItemCreatedOn, ItemUpdatedOn,ItemShortDescription,ItemDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            ItemImage = itemView.findViewById(R.id.item_imageView);
            ItemName = itemView.findViewById(R.id.item_name);
            ItemPlan = itemView.findViewById(R.id.item_plan);
            ItemReleaseDate = itemView.findViewById(R.id.item_releaseDate);
            ItemDuration = itemView.findViewById(R.id.item_duration);
            ItemType = itemView.findViewById(R.id.item_type);
            ItemCreatedOn = itemView.findViewById(R.id.item_createdOn);
            ItemUpdatedOn = itemView.findViewById(R.id.item_UpdatedOn);
            ItemShortDescription = itemView.findViewById(R.id.item_shortDescription);
            ItemDescription = itemView.findViewById(R.id.item_description);
        }
    }

}
