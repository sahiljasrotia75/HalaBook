package com.aps.kthalabook.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aps.kthalabook.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }

    fun registerClicked(view: android.view.View) {
        startActivity(Intent(applicationContext , MainActivity::class.java))
    }

 fun loginClicked(view: android.view.View) {
     onBackPressed()
    }
    fun onBackPressed(view: android.view.View) {
        super.onBackPressed()
    }
}