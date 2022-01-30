package com.aps.kthalabook.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.aps.kthalabook.R
import kotlinx.android.synthetic.main.activity_privacy_tems_about.*


class PrivacyTermsAboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy_tems_about)
        val intent = intent
        val textHeading = intent.extras!!.getString("textHeading")
        when {
            textHeading.equals("Privacy Policy") -> {
                txtheading.text = textHeading
            }
            textHeading.equals("Terms & Conditions") -> {
                txtheading.text = textHeading
            }
            textHeading.equals("About Us") -> {
                txtheading.text = textHeading
            }
            textHeading.equals("Address") -> {
                txtheading.text = textHeading
            }
        }
    }

    fun onBackPressed(view: View) {
        super.onBackPressed()
    }

}
