package com.xheghun.covergenius;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.xheghun.covergenius.adapter.IntroImageSliderAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IntroActivity extends AppCompatActivity {

    @BindView(R.id.intro_img_slider)
    SliderView sliderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ButterKnife.bind(this);
        getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.explore_bg));

        sliderView.setSliderAdapter(new IntroImageSliderAdapter(this));
        sliderView.startAutoCycle();
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setScrollTimeInSec(4);
        sliderView.setIndicatorSelectedColor(getResources().getColor(R.color.colorPrimary));
    }

    @OnClick(R.id.login_btn)
    void gotoLogin() {
        startActivity(new Intent(this,LoginActivity.class));
    }

    @OnClick(R.id.register_btn)
    void gotoRegister() {
        startActivity(new Intent(this,RegisterActivity.class));
    }

}
