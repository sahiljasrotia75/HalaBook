package com.aps.kthalabook.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.aps.kthalabook.R
import com.aps.kthalabook.adapter.ViewPagerAdapter
import com.aps.kthalabook.model.LoginBannerModel
import com.aps.kthalabook.util.Utility
import java.util.ArrayList

class IntroActivity : AppCompatActivity() {

    lateinit var view_pager_offers: ViewPager
    lateinit var dotsLayout: LinearLayout
    val list = ArrayList<LoginBannerModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        initViews()
    }

    fun loginClicked(view: android.view.View) {
        startActivity(Intent(applicationContext , LoginActivity::class.java))

    }

    fun registerClicked(view: android.view.View) {
        startActivity(Intent(applicationContext , RegisterActivity::class.java))

    }

    private fun initViews() {
        view_pager_offers = findViewById(R.id.view_pager_offers)
        dotsLayout = findViewById(R.id.layoutDots)

        list.add(LoginBannerModel("Choose Your Beauty\n Service", R.drawable.onboard_one))
        list.add(LoginBannerModel("Find your nearest salon", R.drawable.onboard_two))
        list.add(LoginBannerModel("Select your preferred\n date and time", R.drawable.onboard_three))
        list.add(LoginBannerModel("Time to treat yourself\n Enjoy your service", R.drawable.onboard_four))


        val viewPagerAdapter = ViewPagerAdapter(applicationContext, list)
        view_pager_offers.adapter = viewPagerAdapter
        view_pager_offers.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                Utility().addBottomDots(list.size, position, dotsLayout, applicationContext)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
        Utility().addBottomDots(list.size, 0, dotsLayout, applicationContext)
    }


}