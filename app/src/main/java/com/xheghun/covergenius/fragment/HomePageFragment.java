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

    @BindView(R.id.grid_items_rc)
    RecyclerView recyclerView;

    @BindView(R.id.policies_rc)
    RecyclerView policyRecyclerView;

    @BindView(R.id.main_img_slider)
    DiscreteScrollView mDiscreteScrollView;
    private List<SliderData> sliderDataList;

    private List<InsuranceType> gridList;

    private List<InsuranceType> listPolicies;


    @BindView(R.id.updates_rc)
    RecyclerView updateRecyclerView;

    private List<BlogPostItemData> blogPostItemDataList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_page, container, false);
        ButterKnife.bind(this, view);
        listPolicies = new ArrayList<>();
        blogPostItemDataList = new ArrayList<>();
        sliderDataList = new ArrayList<>();
        gridList = new ArrayList<>();

        gridRecycler();

        //loadItems recyclerItems
        Thread thread = new Thread() {
            @Override
            public void run() {
                imgSlider();
                policies_rc();
                updates();
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


        GridLayoutManager layoutManager;
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            layoutManager = new GridLayoutManager(getContext(), 2);
        else
            layoutManager = new GridLayoutManager(getContext(), 4);

        recyclerView.setAdapter(new MainGridItemsAdapter(getContext(), gridList));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        updateRecyclerView.setLayoutManager(linearLayoutManager);
        updateRecyclerView.setAdapter(new BlogPostRecyclerAdapter(getContext(), blogPostItemDataList));

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        policyRecyclerView.setAdapter(new InsuranceItemAdapter(getContext(), listPolicies, 2));
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

    private void gridRecycler() {
        String[] title = {"Buy Policies", "Make Claims", "Inspections", "Locate Vendor"};
        int[] icons = {R.drawable.ic_policy, R.drawable.ic_claim, R.drawable.ic_document, R.drawable.ic_route};

        AppCompatActivity[] activities = {new UnknownActivity(), null, null, null};

        for (int i = 0; i < title.length; i++) {
            InsuranceType gridItemData = new InsuranceType();
            gridItemData.setIconRes(icons[i]);
            gridItemData.setTitle(title[i]);
            gridItemData.setActivity(activities[i]);
            gridList.add(gridItemData);
        }


    }

    @OnClick(R.id.blog_fab)
    public void toast() {
        startActivity(new Intent(getContext(), BlogActivity.class));
    }
}
