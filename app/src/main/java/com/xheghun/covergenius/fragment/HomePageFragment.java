package com.xheghun.covergenius.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xheghun.covergenius.BlogActivity;
import com.xheghun.covergenius.R;
import com.xheghun.covergenius.UnknownActivity;
import com.xheghun.covergenius.adapter.BlogPostRecyclerAdapter;
import com.xheghun.covergenius.adapter.InsuranceItemAdapter;
import com.xheghun.covergenius.adapter.MainGridItemsAdapter;
import com.xheghun.covergenius.adapter.SliderAdapter;
import com.xheghun.covergenius.model.BlogPostItemData;
import com.xheghun.covergenius.model.InsuranceType;
import com.xheghun.covergenius.model.SliderData;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomePageFragment extends Fragment {


    @BindView(R.id.policies_rc)
    RecyclerView policyRecyclerView;

    @BindView(R.id.main_img_slider)
    DiscreteScrollView mDiscreteScrollView;
    private List<SliderData> sliderDataList;

    private List<InsuranceType> listPolicies;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_page, container, false);
        ButterKnife.bind(this, view);
        listPolicies = new ArrayList<>();
        sliderDataList = new ArrayList<>();

        //loadItems recyclerItems
        Thread thread = new Thread() {
            @Override
            public void run() {
                imgSlider();
                policies_rc();
            }
        };

        thread.start();

        //load recycler Items
        loadItems();

        return view;
    }


    @OnClick(R.id.profile_img)
    void gotoBuy_P() {
        startActivity(new Intent(getContext(), ProfileFragment.class));
    }


    private void loadItems() {
        mDiscreteScrollView.setAdapter(new SliderAdapter(getContext(), sliderDataList));
        mDiscreteScrollView.setOffscreenItems(2);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),4);
        policyRecyclerView.setAdapter(new InsuranceItemAdapter(getContext(), listPolicies, 2));
        policyRecyclerView.setLayoutManager(gridLayoutManager);
    }


    private void policies_rc() {
        String[] title = {"Travel", "Health", "Auto", "Life", "Home", "Gadget", "Business", "Bespoke"};
        int[] iconsRes = {R.drawable.ic_travel, R.drawable.ic_health, R.drawable.ic_auto,
                R.drawable.ic_life, R.drawable.ic_home, R.drawable.ic_gadget, R.drawable.ic_business, R.drawable.path_ruby};


        for (int i = 0; i < title.length; i++) {
            InsuranceType policies = new InsuranceType();

            policies.setTitle(title[i]);
            policies.setIconRes(iconsRes[i]);
            listPolicies.add(policies);
        }


    }

    private void imgSlider() {
        String title = "Travel";
        String text = getActivity().getResources().getString(R.string.demo_conent);
        String btn_txt = getString(R.string.know_more);
        int imgRes = R.drawable.profile_img;


        for (int i = 0; i < 20; i++) {
            SliderData sliderData = new SliderData();
            sliderData.setTitle(title);
            sliderData.setText(text);
            sliderData.setImageRes(imgRes);
            sliderData.setBtnTxt(btn_txt);

            sliderDataList.add(sliderData);
        }
        //mDiscreteScrollView.setOverScrollEnabled(true);
    }

    @OnClick(R.id.blog_fab)
    public void toast() {
        startActivity(new Intent(getContext(), BlogActivity.class));
    }
}
