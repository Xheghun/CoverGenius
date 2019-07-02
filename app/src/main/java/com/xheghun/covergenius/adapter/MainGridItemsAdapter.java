package com.xheghun.covergenius.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xheghun.covergenius.R;
import com.xheghun.covergenius.model.InsuranceType;

import java.util.List;

public class MainGridItemsAdapter extends RecyclerView.Adapter<MainGridItemsAdapter.MainGridViewHolder> {

    Context mContext;
    List<InsuranceType> listGridItems;

    public MainGridItemsAdapter(Context mContext, List<InsuranceType> listGridItems) {
        this.mContext = mContext;
        this.listGridItems = listGridItems;
    }

    @NonNull
    @Override
    public MainGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.main_grid_items,parent,false);
        return new MainGridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainGridViewHolder holder, int position) {
        InsuranceType items = listGridItems.get(position);
        holder.imageView.setImageResource(items.getIconRes());
        holder.textView.setText(items.getTitle());
        holder.linearLayout.setOnClickListener(view -> {
            if (items.getActivity() != null)
                mContext.startActivity(new Intent(mContext, items.getActivity().getClass()));
        });
    }

    @Override
    public int getItemCount() {
        return listGridItems.size();
    }

    class MainGridViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        LinearLayout linearLayout;
        public MainGridViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.main_grid_icon);
            textView = itemView.findViewById(R.id.main_grid_title);
            linearLayout = itemView.findViewById(R.id.root);
        }
    }
}
