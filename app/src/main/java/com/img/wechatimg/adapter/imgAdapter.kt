package com.img.wechatimg.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.img.wechatimg.ImageActivity
import com.img.wechatimg.R
import kotlinx.android.synthetic.main.item_img.view.*
import javax.xml.transform.Source

/**
 * Created by wuwei on 2017/7/4.
 */
class imgAdapter(var list: Array<String>, var context: Context) : RecyclerView.Adapter<imgAdapter.ViewHolder>() {
     val pairs= arrayOfNulls<Pair<View, String>>(list.size)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        pairs[position] = Pair<View, String>(holder.itemView.item_imgview, "img" + position)
        Glide.with(context).load(list[position]).thumbnail(0.4f).into(holder.itemView.item_imgview)
        holder.itemView.item_imgview.setOnClickListener {
            ImageActivity.startActivity(context, pairs, position, list)
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_img, parent, false))

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)
}