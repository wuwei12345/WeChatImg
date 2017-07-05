package com.img.wechatimg.adapter

import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

/**
 * Created by wuwei on 2017/7/4.
 */
class popAdapter(var look_imgs: List<ImageView>) : PagerAdapter() {

    override fun isViewFromObject(view: View?, `object`: Any) = `object` === view

    override fun getCount(): Int = look_imgs.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(look_imgs[position])
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(look_imgs[position])
        return look_imgs[position]
    }
}