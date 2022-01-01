package com.aps.kthalabook.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout


import com.aps.kthalabook.R
import com.aps.kthalabook.activities.DirectionActivity
import com.aps.kthalabook.adapter.BookingAdapter
import com.aps.kthalabook.adapter.NotificationAapter
import com.aps.kthalabook.adapter.ServiceAdapter
import com.aps.kthalabook.callbacks.CommonInterface
import com.aps.kthalabook.util.Utility


class BookingActivity : AppCompatActivity() {
    lateinit var tab_layout: TabLayout
    lateinit var rv_ser: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)
        rv_ser = findViewById(R.id.rv_ser)
        tab_layout = findViewById(R.id.tab_layout)
        val firstTab = tab_layout.newTab()
        firstTab.text = "Upcoming"
        tab_layout.addTab(firstTab, 0, true)
        val Finished = tab_layout.newTab()
        Finished.text = "Finished"
        tab_layout.addTab(Finished, 1, false)
        val Canceled = tab_layout.newTab()
        Canceled.text = "Canceled"
        tab_layout.addTab(Canceled, 2, false)
        rv_ser.setLayoutManager(LinearLayoutManager(applicationContext))

        rv_ser!!.adapter = BookingAdapter("BOOKING",
            object : CommonInterface {
                override fun onItemClicked(type: String, position: Int) {
                    startActivity( Intent(applicationContext, DirectionActivity::class.java)
                    )
                }
            })


    }
}