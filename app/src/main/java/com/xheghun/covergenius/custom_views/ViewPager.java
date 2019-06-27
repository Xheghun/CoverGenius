package com.xheghun.covergenius.custom_views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;

public class ViewPager extends androidx.viewpager.widget.ViewPager {
    private boolean enabled;

    public ViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public ViewPager(@NonNull Context context) {
        super(context);
        this.enabled = true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onTouchEvent(event);
        }

        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onInterceptTouchEvent(event);
        }

        return false;
    }

    public void setPagingEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
