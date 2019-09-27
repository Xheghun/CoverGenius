package com.xheghun.covergenius.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.xheghun.covergenius.R;
import com.xheghun.covergenius.model.SliderData;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {
    private Context mContext;
    private List<SliderData> mSliderData;

    public SliderAdapter(Context context, List<SliderData> sliderDataList) {
        mContext = context;
        mSliderData = sliderDataList;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.update_item_layout,parent,false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        Glide.with(mContext).load(R.drawable.profile_img).override(holder.imageView.getWidth(),holder.imageView.getHeight())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return 6;
    }


    class SliderViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.post_thumbnail);
        }
    }
}