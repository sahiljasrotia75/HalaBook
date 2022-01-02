package com.aps.kthalabook.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.aps.kthalabook.R
import com.bumptech.glide.Glide


class ServiceImagesAdapter(private val context: Context, private val list: MutableList<Int>) :
    PagerAdapter() {
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = LayoutInflater.from(context).inflate(
            R.layout.service_image_adapter_item,
            container, false
        )
        val txvOffer = view.findViewById<ImageView>(R.id.txv_lay_1)
        Glide.with(context)
            .load(list[position]) //.apply(new RequestOptions().placeholder(R.mipmap.ic_launcher))
            .into(txvOffer)
        container.addView(view)
        return view
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}
