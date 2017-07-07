package com.img.wechatimg.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by wuwei on 2017/7/6.
 */

public class PhotoViewPager extends ViewPager{
    private static final String TAG = PhotoViewPager.class.getSimpleName();

    public PhotoViewPager(Context context) {
        super(context);
    }

    public PhotoViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            Log.w(TAG, "onInterceptTouchEvent() ", ex);
            ex.printStackTrace();
        }
        return false;
    }
}
