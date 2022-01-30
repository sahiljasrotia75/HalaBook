package com.aps.kthalabook.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R
import com.aps.kthalabook.adapter.ServiceAdapter
import com.aps.kthalabook.callbacks.CommonInterface
import com.aps.kthalabook.util.Utility


class LocationServiceActivity : AppCompatActivity() {
    lateinit var rv_ser: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_service)
        initViews()
        setServiceAdapter()
    }

    private fun setServiceAdapter() {

        rv_ser!!.adapter = ServiceAdapter("HORIZONTAL",
            object : CommonInterface {
                override fun onItemClicked(type: String, position: Int) {
                    if (type == "btn_book") {
                        startActivity(Intent(applicationContext, MyCartActivity::class.java))

                    }

                }
            })

    }

    private fun initViews() {
        rv_ser = findViewById(R.id.rv_ser)
        rv_ser.setLayoutManager(LinearLayoutManager(applicationContext))
    }
    fun onBackPressed(view: android.view.View) {
        super.onBackPressed()
    }
}