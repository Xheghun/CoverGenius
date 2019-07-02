package com.xheghun.covergenius.fragment;


import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xheghun.covergenius.R;
import com.xheghun.covergenius._interface.NavigationHost;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class VehicleDetailsFragment extends Fragment {
    @BindView(R.id.state_dialog)
    TextView state_dialog;

    @BindView(R.id.car_brand_dialog)
    TextView car_brand;

    @BindView(R.id.car_model_dialog)
    TextView car_model;

    @BindView(R.id.car_year_dialog)
    TextView car_year;

    public VehicleDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.address);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_enter_vehicle_details, container, false);
        ButterKnife.bind(this, view);
        getActivity().setTitle(R.string._continue);
        return view;
    }

    @OnClick(R.id.state_dialog)
    void showDialog() {
        dialog(state_dialog, "State");
    }


    @OnClick(R.id.car_brand_dialog)
    void showBrandDialog() {
        Toast.makeText(getContext(), "YASS", Toast.LENGTH_SHORT).show();
        dialog(car_brand, "Car Brand");
    }

    @OnClick(R.id.car_model_dialog)
    void showModelDialog() {
        dialog(car_model, "Car Model");
    }

    @OnClick(R.id.car_year_dialog)
    void showYearDialog() {
        dialog(car_year, "Car Year");
    }

    private void dialog(TextView textView, String dialogTitle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Select " + dialogTitle);
        //radio list
        String[] list = getResources().getStringArray(R.array.lorem_ipsum);
        int checkedItem = 0;
        builder.setSingleChoiceItems(list, checkedItem, (dialogInterface, i) -> textView.setText(list[i] + " " + i));

        builder.setPositiveButton("Ok", (dialogInterface, i) -> dialogInterface.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @OnClick(R.id.next_step_btn)
    void gotoNext() {
        ((NavigationHost) getActivity()).navigateTo(new PolicyInformationFragment(), true);
    }

    @OnClick(R.id.prev_step_btn)
    void gotoPrev() {
        getActivity().onBackPressed();
    }


}
