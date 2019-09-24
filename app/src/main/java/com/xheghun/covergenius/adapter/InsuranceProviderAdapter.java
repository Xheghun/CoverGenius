package com.xheghun.covergenius.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xheghun.covergenius.R;
import com.xheghun.covergenius.model.InsuranceProvider;

import java.util.List;

public class InsuranceProviderAdapter extends RecyclerView.Adapter<InsuranceProviderAdapter.InsuranceProviderViewHolder> {

    private Context mContex;
    private List<InsuranceProvider> mProviderList;
    public InsuranceProviderAdapter(Context context, List<InsuranceProvider> providerList) {
        mContex = context;
        mProviderList = providerList;
    }

    @NonNull
    @Override
    public InsuranceProviderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContex).inflate(R.layout.insurance_provider_item,parent,false);

        return new InsuranceProviderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InsuranceProviderViewHolder holder, int position) {
        InsuranceProvider provider = mProviderList.get(position);
        holder.name.setText(provider.getProviderName());
    }

    @Override
    public int getItemCount() {
        return mProviderList.size();
    }


    class InsuranceProviderViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;

        public InsuranceProviderViewHolder(@NonNull View itemView) {
            super(itemView);
             name = itemView.findViewById(R.id.insurance_provider_name);
        }
    }

}
