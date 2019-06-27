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
import com.xheghun.covergenius.model.BlogPostItemData;

import java.util.List;

public class BlogPostRecyclerAdapter extends RecyclerView.Adapter<BlogPostRecyclerAdapter.UpdateItemViewHolder> {

    int layoutType;
    private Context mContext;
    private boolean flag = true;
    private List<BlogPostItemData> blogPostItemDataList;

    public BlogPostRecyclerAdapter(Context mContext, List<BlogPostItemData> blogPostItemDataList) {
        this.mContext = mContext;
        this.blogPostItemDataList = blogPostItemDataList;
    }

    public BlogPostRecyclerAdapter(Context mContext, List<BlogPostItemData> blogPostItemDataList, int layoutType) {
        this.mContext = mContext;
        this.blogPostItemDataList = blogPostItemDataList;
        this.layoutType = layoutType;
    }

    @NonNull
    @Override
    public UpdateItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (layoutType == 2)
            view = LayoutInflater.from(mContext).inflate(R.layout.blog_post_items, parent, false);
        else
            view = LayoutInflater.from(mContext).inflate(R.layout.update_item_layout, parent, false);
        return new UpdateItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpdateItemViewHolder holder, int position) {
        BlogPostItemData itemData = blogPostItemDataList.get(position);

        holder.title.setText(itemData.getTitle());
        holder.text.setText(itemData.getText());
        holder.date.setText(itemData.getDate());
        holder.author.setText(itemData.getAuthor());

        Glide.with(mContext).load(itemData.getImg())
                .override(holder.imageView.getWidth(), holder.imageView.getHeight())
                .into(holder.imageView);

        holder.fav.setOnClickListener(view1 -> {
            if (flag) {
                holder.fav.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_favorite_fill));
                flag = false;
            } else if (!flag) {
                holder.fav.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_favorite_outlined));
                flag = true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return blogPostItemDataList.size();
    }

    class UpdateItemViewHolder extends RecyclerView.ViewHolder {
        TextView title,text,date,author;
        ImageView imageView;
        FloatingActionButton share,fav;

        UpdateItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.post_name);
            text = itemView.findViewById(R.id.post_content);
            date = itemView.findViewById(R.id.post_date);
            author = itemView.findViewById(R.id.post_author);

            imageView = itemView.findViewById(R.id.post_thumbnail);
            share = itemView.findViewById(R.id.share_post_fab);
            fav = itemView.findViewById(R.id.like_post_fab);
        }
    }
}
