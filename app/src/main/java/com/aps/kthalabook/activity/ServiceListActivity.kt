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


class ServiceListActivity : AppCompatActivity() {
    lateinit var rv_ser: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_list)
        rv_ser = findViewById(R.id.rv_ser)
        rv_ser.layoutManager = (LinearLayoutManager(applicationContext))
        rv_ser!!.adapter = ServiceAdapter("VERTICAL_MATCH",
            object : CommonInterface {
                override fun onItemClicked(type: String, position: Int) {
                    Utility().ratingDialog(this@ServiceListActivity)
                }
            })

    }
}