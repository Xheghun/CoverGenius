package com.xheghun.covergenius;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IntroActivity extends AppCompatActivity {
    @BindView(R.id.intro_view_pager)
    ViewPager viewPager;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        ButterKnife.bind(this);
        getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.explore_bg));

    }

    @OnClick(R.id.login_btn)
    void gotoLogin() {
        startActivity(new Intent(this,LoginActivity.class));
    }

    @OnClick(R.id.register_btn)
    void gotoRegister() {
        startActivity(new Intent(this,RegisterActivity.class));
    }

    @OnClick(R.id.explore_btn)
    void gotoPolicy() {
        startActivity(new Intent(this,BuyPolicyActivity.class));
    }
}
