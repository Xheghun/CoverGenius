package com.xheghun.covergenius.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smarteist.autoimageslider.SliderViewAdapter;

public class IntroImageSliderAdapter extends SliderViewAdapter<IntroImageSliderAdapter.SliderAdapterVH> {

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        return null;
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackGround;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
        }
    }

}
