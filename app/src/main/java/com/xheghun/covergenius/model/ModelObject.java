package com.xheghun.covergenius.model;

import androidx.fragment.app.Fragment;

import com.xheghun.covergenius.R;
import com.xheghun.covergenius.fragment.MainBlogFragment;

public enum ModelObject {

    ONE(R.string.address, new MainBlogFragment()),
    TWO(R.string.address, new MainBlogFragment()),
    FOUR(R.string.address, new MainBlogFragment());


    private int mTitleResId;
    private Fragment mLayoutResId;

    ModelObject(int titleResId, Fragment layoutResId) {
        mLayoutResId = layoutResId;
        mTitleResId = titleResId;
    }

    public int getmTitleResId() {
        return mTitleResId;
    }

    public Fragment getmLayoutResId() {
        return mLayoutResId;
    }
}
