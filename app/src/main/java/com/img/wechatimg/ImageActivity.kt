package com.img.wechatimg

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Pair
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.img.wechatimg.adapter.popAdapter
import kotlinx.android.synthetic.main.activity_image.*
import kotlin.collections.ArrayList


class ImageActivity : AppCompatActivity() {
    var look_imgs = ArrayList<ImageView>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        initview()
    }

    private fun initview() {
        look_imgs.clear()
        var list = intent.extras.getStringArray(STRLIST)
        list.indices.forEach { s ->
            val img = ImageView(this)
            Glide.with(this).load(list[s]).into(img)
            look_imgs.add(img)
            img.setOnClickListener { supportFinishAfterTransition() }
        }
        viewpage.transitionName = "img" + intent.getIntExtra(IMGPOS, 0)
        viewpage.adapter = popAdapter(look_imgs)
        viewpage.currentItem = intent.getIntExtra(IMGPOS, 0)
        viewpage.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                viewpage.transitionName = "img" + position
            }

            override fun onPageSelected(position: Int) {}
        })
    }

    companion object {
        val IMGPOS = "IMG"
        val STRLIST = "STRLIST"
        fun startActivity(context: Context, imageView: Array<Pair<View, String>?>, postion: Int, list: Array<String>) {
            val intent = Intent(context, ImageActivity::class.java)
            val bundle = Bundle()
            bundle.putStringArray(STRLIST, list)
            intent.putExtra(IMGPOS, postion)
            intent.putExtras(bundle)
            if (Build.VERSION.SDK_INT > 21) {
                context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(context as Activity, *imageView).toBundle())
            } else {
                context.startActivity(intent)
            }
        }

    }


}
