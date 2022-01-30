package com.aps.kthalabook.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R
import com.aps.kthalabook.adapters.CartAdapter


class MyCartActivity : AppCompatActivity() {
    lateinit var rv_ser: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)
        initViews()
        setCartAdapter()
        findViewById<View>(R.id.btn_confirm).setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    applicationContext,
                    ConfirmOrderActivity::class.java
                )
            )
        }
    }

    private fun setCartAdapter() {
        rv_ser!!.adapter = CartAdapter()
    }

    private fun initViews() {
        rv_ser = findViewById(R.id.rv_ser)
        rv_ser.setLayoutManager(LinearLayoutManager(applicationContext))
    }
    fun onBackPressed(view: android.view.View) {
        super.onBackPressed()
    }
}