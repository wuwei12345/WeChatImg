package com.img.wechatimg.view

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent

/**
 * Created by wuwei on 2017/7/6.
 */

class PhotoViewPager : ViewPager {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        try {
            return super.onInterceptTouchEvent(ev)
        } catch (ex: IllegalArgumentException) {
            Log.w(TAG, "onInterceptTouchEvent() ", ex)
            ex.printStackTrace()
        }

        return false
    }

    companion object {
        private val TAG = PhotoViewPager::class.java.simpleName
    }
}
