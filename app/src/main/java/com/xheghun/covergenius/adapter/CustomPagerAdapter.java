package com.xheghun.covergenius.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.xheghun.covergenius.fragment.InsuranceProviderFragment;
import com.xheghun.covergenius.fragment.ProfileFragment;

public class CustomPagerAdapter extends FragmentPagerAdapter {

    private int NUM_ITEMS = 1;

    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new InsuranceProviderFragment();
            case 1:
                return new ProfileFragment();
            case 2:
                return null;
            default:
                return null;
        }
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
