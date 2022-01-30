package com.aps.kthalabook.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aps.kthalabook.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }
    fun onBackPressed(view: android.view.View) {
        super.onBackPressed()
    }
}