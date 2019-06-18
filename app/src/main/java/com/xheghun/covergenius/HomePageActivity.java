package com.xheghun.covergenius;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class HomePageActivity extends AppCompatActivity {

    Thread thread;

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

    List<BlogPostItemData> blogPostItemDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        ButterKnife.bind(this);

        listPolicies = new ArrayList<>();
        blogPostItemDataList = new ArrayList<>();
        sliderDataList = new ArrayList<>();
        gridList = new ArrayList<>();

        //loadItems recyclerItems
        thread = new Thread() {
            @Override
            public void run() {
                imgSlider();
                gridRecycler();
                policies_rc();
                updates();
            }
        };

        thread.start();

        //load recycler Items
        loadItems();
    }

    private void loadItems() {
        mDiscreteScrollView.setAdapter(new SliderAdapter(this, sliderDataList));
        mDiscreteScrollView.setOffscreenItems(2);


        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            layoutManager = new GridLayoutManager(this, 2);
        else
            layoutManager = new GridLayoutManager(this, 4);
        recyclerView.setAdapter(new MainGridItemsAdapter(this, gridList));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        updateRecyclerView.setLayoutManager(linearLayoutManager);
        updateRecyclerView.setAdapter(new BlogPostRecyclerAdapter(this, blogPostItemDataList));


        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        policyRecyclerView.setAdapter(new InsuranceItemAdapter(this, listPolicies, 2));
        policyRecyclerView.setLayoutManager(linearLayoutManager);
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

    private void updates() {
        String title = "Travel Insurance just got Better with Covergenius";
        String text = "More than 100,000 property casualty,insurance professionals subscribe too..";
        String date = "May 15 2019";
        String author = "John Doe";
        int imgRes = R.drawable.profile_img;


        for (int i = 0; i < 9; i++) {
            BlogPostItemData blogPostItemData = new BlogPostItemData();
            blogPostItemData.setTitle(title);
            blogPostItemData.setText(text);
            blogPostItemData.setDate(date);
            blogPostItemData.setAuthor(author);
            blogPostItemData.setImg(imgRes);
            blogPostItemDataList.add(blogPostItemData);
        }


    }


    private void imgSlider() {
        String title = "Travel";
        String text = getString(R.string.demo_conent);
        String btn_txt = getString(R.string.know_more);
        int imgRes = R.drawable._demo_img;


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

    private void gridRecycler() {
        String[] title = {"Buy Policies", "Make Claims", "Inspections", "Locate Vendor"};
        int[] icons = {R.drawable.ic_policy, R.drawable.ic_claim, R.drawable.ic_document, R.drawable.ic_route};

        for (int i = 0; i < title.length; i++) {
            InsuranceType gridItemData = new InsuranceType();
            gridItemData.setIconRes(icons[i]);
            gridItemData.setTitle(title[i]);
            gridList.add(gridItemData);
        }


    }

    public void toast(View view) {
        startActivity(new Intent(this, BlogActivity.class));
    }
}
