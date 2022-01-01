package com.aps.kthalabook.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.aps.kthalabook.R
import com.aps.kthalabook.adapter.ServiceImagesAdapter
import com.aps.kthalabook.util.Utility

import java.util.ArrayList


class ServiceDetailActivity : AppCompatActivity() {
    lateinit var view_pager_offers: ViewPager
    lateinit var dotsLayout: LinearLayout
    var list: MutableList<String> = ArrayList()
    var count = 0
    var rv_cat: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_detail)
        initViews()
        manageClickListener()
    }

    private fun manageClickListener() {
        findViewById<View>(R.id.rl_view).setOnClickListener { view: View? ->
            startActivity(
                Intent(
                    applicationContext,
                    SpecialistActivity::class.java
                )
            )
        }
        findViewById<View>(R.id.btn_login).setOnClickListener { view: View? ->
            startActivity(
                Intent(
                    applicationContext,
                    MyScheduleActivity::class.java
                )
            )
        }
    }

    fun initViews() {
        view_pager_offers = findViewById(R.id.view_pager_offers)
        dotsLayout = findViewById(R.id.layoutDots)
        list.add("https://picsum.photos/200/300")
        list.add("https://picsum.photos/200/300?grayscale")
        list.add("https://picsum.photos/200/300/?blur")
        val viewPagerAdapter = ServiceImagesAdapter(applicationContext, list)
        view_pager_offers.setAdapter(viewPagerAdapter)
        view_pager_offers.setAdapter(viewPagerAdapter)
        view_pager_offers.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                Utility().addBottomDots(list.size, position, dotsLayout, applicationContext)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
        Utility().addBottomDots(list.size, 0, dotsLayout, applicationContext)
    }
}