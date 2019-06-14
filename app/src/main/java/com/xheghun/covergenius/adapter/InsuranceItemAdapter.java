package com.xheghun.covergenius.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xheghun.covergenius.R;
import com.xheghun.covergenius.model.InsuranceType;

import java.util.List;

public class InsuranceItemAdapter extends RecyclerView.Adapter<InsuranceItemAdapter.InsuranceViewHolder> {

    private Context mContext;
    private List<InsuranceType> insuranceTypeTypeList;
    private int layout_type;

    public InsuranceItemAdapter(Context mContext, List<InsuranceType> insuranceTypeTypeList, int layout_type) {
        this.mContext = mContext;
        this.insuranceTypeTypeList = insuranceTypeTypeList;
        this.layout_type = layout_type;
    }

    public InsuranceItemAdapter(Context mContext, List<InsuranceType> insuranceTypeTypeList) {
        this.mContext = mContext;
        this.insuranceTypeTypeList = insuranceTypeTypeList;
    }

    @NonNull
    @Override
    public InsuranceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (layout_type == 2)
            view = LayoutInflater.from(mContext).inflate(R.layout.insurance_item_type_2, parent, false);
        else
            view = LayoutInflater.from(mContext).inflate(R.layout.insurance_item, parent, false);
        return new InsuranceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InsuranceViewHolder holder, int position) {
        InsuranceType insuranceType = insuranceTypeTypeList.get(position);
        holder.imageView.setImageResource(insuranceType.getIconRes());
        holder.textView.setText(insuranceType.getTitle());
    }

    @Override
    public int getItemCount() {
        return insuranceTypeTypeList.size();
    }

    class InsuranceViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public InsuranceViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.insurance_icon);
            textView = itemView.findViewById(R.id.insurance_name);
        }
    }
}
