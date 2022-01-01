package com.aps.kthalabook

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.aps.kthalabook.activity.IntroActivity

class SplashActivity : AppCompatActivity() {
    private var mDelayHandler: Handler? = null
    private val mSplashDelay: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(mRunnable, mSplashDelay)

    }

    public override fun onDestroy() {
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }

        super.onDestroy()
    }

    private val mRunnable: Runnable = Runnable {
        startActivity(Intent(applicationContext , IntroActivity::class.java))
            finish()
        }
}