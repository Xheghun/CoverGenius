package com.xheghun.covergenius.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.xheghun.covergenius.R;
import com.xheghun.covergenius.model.UpdateItemData;

import java.util.List;

public class UpdateRecyclerAdapter extends RecyclerView.Adapter<UpdateRecyclerAdapter.UpdateItemViewHolder> {

    private Context mContext;
    private List<UpdateItemData> updateItemDataList;

    public UpdateRecyclerAdapter(Context mContext, List<UpdateItemData> updateItemDataList) {
        this.mContext = mContext;
        this.updateItemDataList = updateItemDataList;
    }

    @NonNull
    @Override
    public UpdateItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.update_item_layout,parent,false);
        return new UpdateItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpdateItemViewHolder holder, int position) {
        UpdateItemData itemData = updateItemDataList.get(position);

        holder.title.setText(itemData.getTitle());
        holder.title.setText(itemData.getText());
        holder.date.setText(itemData.getDate());
        holder.author.setText(itemData.getAuthor());
        Glide.with(mContext).load(itemData.getImg()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return updateItemDataList.size();
    }

    class UpdateItemViewHolder extends RecyclerView.ViewHolder {
        TextView title,text,date,author;
        ImageView imageView;
        FloatingActionButton share,fav;
        public UpdateItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.update_title);
            text = itemView.findViewById(R.id.update_summary);
            date = itemView.findViewById(R.id.update_date);
            author = itemView.findViewById(R.id.update_author);

            imageView = itemView.findViewById(R.id.update_img);
            share = itemView.findViewById(R.id.share_update);
            fav = itemView.findViewById(R.id.like_update);
        }
    }
}
