package com.aps.kthalabook.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aps.kthalabook.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }


    fun loginClicked(view: android.view.View) {
        startActivity(Intent(applicationContext , MainActivity::class.java))
    }

    fun registerClicked(view: android.view.View) {
        startActivity(Intent(applicationContext , RegisterActivity::class.java))
    }


}