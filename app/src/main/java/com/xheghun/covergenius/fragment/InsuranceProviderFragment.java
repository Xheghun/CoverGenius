package com.xheghun.covergenius.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xheghun.covergenius.R;
import com.xheghun.covergenius._interface.NavigationHost;
import com.xheghun.covergenius.adapter.InsuranceProviderAdapter;
import com.xheghun.covergenius.model.InsuranceProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class InsuranceProviderFragment extends Fragment {

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.insurance_provider_rc)
    RecyclerView recyclerView;
    private List<InsuranceProvider> providerList;

    public InsuranceProviderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_insurance_provider, container, false);
        ButterKnife.bind(this, view);
        progressBar.setMax(100);
        progressBar.setProgress(20);

        int i = 0;
        providerList = new ArrayList<>();
        while (i < 8) {
            InsuranceProvider insuranceProvider = new InsuranceProvider();
            insuranceProvider.setProviderName("Lorem Ipsum Porem");
            i++;

            providerList.add(insuranceProvider);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new InsuranceProviderAdapter(getContext(), providerList));

        return view;
    }

    @OnClick(R.id.next_step_btn)
    void gotoNext() {
        ((NavigationHost) Objects.requireNonNull(getActivity())).navigateTo(new VehicleDetailsFragment(), false);
    }
}
