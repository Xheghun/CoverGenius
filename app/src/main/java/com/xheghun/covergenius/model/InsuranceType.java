package com.xheghun.covergenius.model;

import androidx.appcompat.app.AppCompatActivity;

public class InsuranceType {
    private int iconRes;

    public void setIconRes(int iconRes) {
        this.iconRes = iconRes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    private AppCompatActivity activity;

    public AppCompatActivity getActivity() {
        return activity;
    }

    public void setActivity(AppCompatActivity activity) {
        this.activity = activity;
    }


    public int getIconRes() {
        return iconRes;
    }

    public String getTitle() {
        return title;
    }
}
