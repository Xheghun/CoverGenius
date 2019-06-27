package com.xheghun.covergenius.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.xheghun.covergenius.R;

public class IntroImageSliderAdapter extends SliderViewAdapter<IntroImageSliderAdapter.SliderAdapterVH> {
    private Context mContext;

    public IntroImageSliderAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.intro_img_item, null);
        return new SliderAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        viewHolder.textViewDescription.setText("Partner with Covergenius Today");
        Glide.with(mContext).load(R.drawable.profile_img)
                .override(viewHolder.imageViewBackGround.getWidth(), viewHolder.imageViewBackGround.getHeight())
                .into(viewHolder.imageViewBackGround);
    }
    @Override
    public int getCount() {
        return 6;
    }
    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {
        View itemView;
        ImageView imageViewBackGround;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackGround = itemView.findViewById(R.id.intro_img);
            textViewDescription = itemView.findViewById(R.id.intro_img_desc);
            this.itemView = itemView;
        }
    }

}
