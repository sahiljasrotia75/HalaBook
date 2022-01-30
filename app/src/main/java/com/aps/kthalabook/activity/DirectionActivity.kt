package com.aps.kthalabook.activities

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.aps.kthalabook.R
import com.aps.kthalabook.adapter.BookingAdapter
import com.aps.kthalabook.adapter.ServiceImagesAdapter
import com.aps.kthalabook.callbacks.CommonInterface
import com.aps.kthalabook.util.Utility
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.ArrayList

class DirectionActivity : AppCompatActivity() {
    lateinit var view_pager_offers: ViewPager
    lateinit var dotsLayout: LinearLayout
    var list: MutableList<Int> = ArrayList()
    var count = 0
    lateinit var rv_ser: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_direction)
        initViews()
        rv_ser = findViewById(R.id.rv_ser)
        rv_ser.setLayoutManager(LinearLayoutManager(applicationContext))


        rv_ser!!.adapter = BookingAdapter("DIRECTION",
            object : CommonInterface {
                override fun onItemClicked(type: String, position: Int) {
                    if (type=="Direction"){
                        showCancelDialog()
                    }

                }
            })
    }

    private fun initViews() {
        view_pager_offers = findViewById(R.id.view_pager_offers)
        dotsLayout = findViewById(R.id.layoutDots)
        list.add(R.drawable.nearest_image_two)
        list.add(R.drawable.nearest_image_one)
        list.add(R.drawable.nearest_image_two)
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

    fun showCancelDialog() {
        val dialog = Dialog(this@DirectionActivity)
        dialog.setContentView(R.layout.location_dialog)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        val txt_dec = dialog.findViewById<TextView>(R.id.txt_dec)
        val iv_image = dialog.findViewById<ImageView>(R.id.iv_image)
        txt_dec.text = "Are you sure you would like to cancel your booking?"
        Glide.with(applicationContext)
            .load(R.drawable.cancel_booking)
            .apply(RequestOptions().placeholder(R.drawable.logo))
            .into(iv_image)

        dialog.findViewById<View>(R.id.btn_no).setOnClickListener { v: View? -> dialog.dismiss() }
        dialog.findViewById<View>(R.id.btn_yes).setOnClickListener { v: View? ->
            dialog.dismiss()
            showCancelReasonDialog()
        }
    }

    fun showCancelReasonDialog() {
        val dialog = Dialog(this@DirectionActivity)
        dialog.setContentView(R.layout.cancel_reason_dialog)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        dialog.findViewById<View>(R.id.btn_no).setOnClickListener { v: View? -> dialog.dismiss() }
        dialog.findViewById<View>(R.id.btn_yes).setOnClickListener { v: View? -> dialog.dismiss() }
    }
    fun onBackPressed(view: android.view.View) {
        super.onBackPressed()
    }
}