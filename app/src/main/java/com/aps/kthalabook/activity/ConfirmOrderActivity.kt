package com.aps.kthalabook.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.aps.kthalabook.R

class ConfirmOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_order)
    }
    fun onBackPressed(view: android.view.View) {
        super.onBackPressed()
    }

    fun goBacktoHome(view: View) {
        startActivity(Intent(applicationContext , MainActivity::class.java))
    }
}