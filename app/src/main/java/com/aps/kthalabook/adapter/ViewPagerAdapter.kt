package com.aps.kthalabook.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.aps.kthalabook.R
import com.aps.kthalabook.model.LoginBannerModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class ViewPagerAdapter(private val context: Context, list: List<LoginBannerModel>) :
    PagerAdapter() {
    private val list: List<LoginBannerModel>
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = LayoutInflater.from(context).inflate(
            R.layout.viewpager_item,
            container, false
        )
        val txvOffer = view.findViewById<ImageView>(R.id.txv_lay_1)
        val txt_title = view.findViewById<TextView>(R.id.txt_title)
        Glide.with(context)
            .load(list[position].image)
            .apply(RequestOptions().placeholder(R.mipmap.ic_launcher))
            .into(txvOffer)
        txt_title.text = "" + list[position].text
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

    init {
        this.list = list
    }
}