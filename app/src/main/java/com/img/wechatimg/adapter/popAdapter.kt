package com.img.wechatimg.adapter

import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.img.wechatimg.ImageActivity
import com.img.wechatimg.R
import kotlinx.android.synthetic.main.item_pic_show.view.*
import uk.co.senab.photoview.PhotoViewAttacher

/**
 * Created by wuwei on 2017/7/4.
 */
class popAdapter(var look_imgs: Array<String>) : PagerAdapter(){
    override fun isViewFromObject(view: View?, `object`: Any) = `object` === view

    override fun getCount(): Int = look_imgs.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        ( container as ViewPager).removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view=View.inflate(container.context, R.layout.item_pic_show,null)
        Glide.with(container.context).load(look_imgs[position]).into(view.pic_photoview)
        view.pic_photoview.setOnPhotoTapListener(object :PhotoViewAttacher.OnPhotoTapListener{
            override fun onPhotoTap(view: View, x: Float, y: Float) {
                (container.context as ImageActivity).supportFinishAfterTransition()
            }

            override fun onOutsidePhotoTap() {
            }

        })
        (container as ViewPager).addView(view)
        return view
    }


}