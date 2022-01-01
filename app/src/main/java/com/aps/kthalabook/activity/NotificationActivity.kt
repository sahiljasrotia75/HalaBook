package com.aps.kthalabook.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R
import com.aps.kthalabook.adapter.NotificationAapter
import com.google.android.material.tabs.TabLayout


class NotificationActivity : AppCompatActivity() {
    lateinit var tab_layout: TabLayout
    lateinit var rv_notification: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        rv_notification = findViewById(R.id.rv_notification)
        tab_layout = findViewById(R.id.tab_layout)
        val firstTab = tab_layout.newTab()
        firstTab.text = "Important"
        tab_layout.addTab(firstTab, 0, true)
        val firstTab2 = tab_layout.newTab()
        firstTab2.text = "Promotion"
        tab_layout.addTab(firstTab2, 1, false)
        rv_notification.setLayoutManager(LinearLayoutManager(applicationContext))
        rv_notification.setAdapter(NotificationAapter())
    }
}