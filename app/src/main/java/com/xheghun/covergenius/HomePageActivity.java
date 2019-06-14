package com.xheghun.covergenius;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;

import com.xheghun.covergenius.adapter.InsuranceItemAdapter;
import com.xheghun.covergenius.adapter.MainGridItemsAdapter;
import com.xheghun.covergenius.adapter.SliderAdapter;
import com.xheghun.covergenius.adapter.UpdateRecyclerAdapter;
import com.xheghun.covergenius.model.InsuranceType;
import com.xheghun.covergenius.model.SliderData;
import com.xheghun.covergenius.model.UpdateItemData;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePageActivity extends AppCompatActivity {

    @BindView(R.id.grid_items_rc)
    RecyclerView recyclerView;

    @BindView(R.id.policies_rc)
    RecyclerView policyRecyclerView;

    @BindView(R.id.main_img_slider)
    DiscreteScrollView mDiscreteScrollView;
    List<SliderData> sliderDataList;

    List<InsuranceType> gridList;
    GridLayoutManager layoutManager;

    List<InsuranceType> listPolicies;
    LinearLayoutManager linearLayoutManager;


    @BindView(R.id.updates_rc)
    RecyclerView updateRecyclerView;

    List<UpdateItemData> updateItemDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        ButterKnife.bind(this);


        imgSlider();
        gridRecycler();
        policies_rc();
        updates();

    }

    private void updates() {
        String titile = "Travel Insurance just got Better with Covergenius";
        String text = "More than 100,000 property casualty,insurance professionals subscribe too..";
        String date = "May 15 2019";
        String author = "John Doe";
        int imgRes = R.drawable.profile_img;

        updateItemDataList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            UpdateItemData updateItemData = new UpdateItemData();
            updateItemData.setTitle(titile);
            updateItemData.setText(text);
            updateItemData.setDate(date);
            updateItemData.setAuthor(author);
            updateItemData.setImg(imgRes);
            updateItemDataList.add(updateItemData);
        }

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        updateRecyclerView.setLayoutManager(linearLayoutManager);
        updateRecyclerView.setAdapter(new UpdateRecyclerAdapter(this,updateItemDataList));
    }

    private void policies_rc() {
        String[] title = {"Travel","Health","Auto","Life","Home","Gadget","Business","Bespoke"};
        int[] iconsRes = {R.drawable.ic_travel,R.drawable.ic_health,R.drawable.ic_auto,
                R.drawable.ic_life,R.drawable.ic_home,R.drawable.ic_gadget,R.drawable.ic_business,R.drawable.path_ruby};

        listPolicies = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            InsuranceType policies = new InsuranceType();

            policies.setTitle(title[i]);
            policies.setIconRes(iconsRes[i]);

            listPolicies.add(policies);
        }

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        policyRecyclerView.setAdapter(new InsuranceItemAdapter(this,listPolicies,2));
        policyRecyclerView.setLayoutManager(linearLayoutManager);
    }

    private void imgSlider() {
        String[] title = {"Travel","Travel","Travel","Travel"};
        String[] text = {getString(R.string.demo_conent),getString(R.string.demo_conent),getString(R.string.demo_conent),getString(R.string.demo_conent)};
        String[] btn_txt = {getString(R.string.know_more),getString(R.string.know_more),getString(R.string.know_more),getString(R.string.know_more)};
        int[] imgRes = {R.drawable._demo_img,R.drawable._demo_img,R.drawable._demo_img,R.drawable._demo_img};

        sliderDataList = new ArrayList<>();
        for (int i = 0; i < title.length;i++) {
            SliderData sliderData = new SliderData();
            sliderData.setTitle(title[i]);
            sliderData.setText(text[i]);
            sliderData.setImageRes(imgRes[i]);
            sliderData.setBtnTxt(btn_txt[i]);

            sliderDataList.add(sliderData);
        }

        mDiscreteScrollView.setAdapter(new SliderAdapter(this,sliderDataList));
        mDiscreteScrollView.setOffscreenItems(2);
        //mDiscreteScrollView.setOverScrollEnabled(true);
    }

    private void gridRecycler() {
        String[] title = {"Buy Policies","Make Claims","Inspections","Locate Vendor"};
        int[] icons = {R.drawable.ic_policy,R.drawable.ic_claim,R.drawable.ic_document,R.drawable.ic_route};
        gridList = new ArrayList<>();
        for (int i = 0; i < title.length;i++) {
            InsuranceType gridItemData = new InsuranceType();
            gridItemData.setIconRes(icons[i]);
            gridItemData.setTitle(title[i]);
            gridList.add(gridItemData);
        }

        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            layoutManager = new GridLayoutManager(this,2);
        else
            layoutManager = new GridLayoutManager(this,4);


        recyclerView.setAdapter(new MainGridItemsAdapter(this,gridList));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
    }
}
