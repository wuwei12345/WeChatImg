package com.img.wechatimg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.img.wechatimg.adapter.imgAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initview()
    }

    private fun initview() {
        act_recyclerview.layoutManager = GridLayoutManager(this, 3)
        act_recyclerview.adapter = imgAdapter(resources.getStringArray(R.array.array), this)
    }
}
