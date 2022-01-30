package com.aps.kthalabook.activity


import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.aps.kthalabook.R
import com.aps.kthalabook.adapter.FragmentAdapter
import com.aps.kthalabook.fragments.BookingFragment
import com.aps.kthalabook.fragments.HomeFragment
import com.aps.kthalabook.fragments.LocationFragment
import com.aps.kthalabook.fragments.NotificationFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import java.util.ArrayList





class MainActivity : AppCompatActivity() {
    var drawer_layout: DrawerLayout? = null
    var et_search: EditText? = null
    var view_pager: ViewPager2? = null
    var bottomNavigationView: BottomNavigationView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setFragmentAdapter()
        manageClickListener()
        showLocationDialog();
    }

    private fun setFragmentAdapter() {
        val list: MutableList<Fragment> = ArrayList()
        list.add(HomeFragment())
        list.add(LocationFragment())
        list.add(BookingFragment())
        list.add(NotificationFragment())
        val fragmentAdapter = FragmentAdapter(this@MainActivity, list)
        view_pager!!.adapter = fragmentAdapter
        view_pager!!.isUserInputEnabled = false


        bottomNavigationView!!.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_dash -> {
                    view_pager!!.currentItem = 0
                    bottomNavigationView!!.menu.findItem(R.id.nav_dash).isChecked = true
                    et_search!!.visibility = View.VISIBLE
                }
                R.id.nav_location -> {
                    view_pager!!.currentItem = 1
                    bottomNavigationView!!.menu.findItem(R.id.nav_location).isChecked = true
                    et_search!!.visibility = View.VISIBLE
                }
                R.id.nav_booking -> {
                    view_pager!!.currentItem = 2
                    bottomNavigationView!!.menu.findItem(R.id.nav_booking).isChecked = true
                    et_search!!.visibility = View.VISIBLE
                }
                R.id.nav_notification -> {
                    view_pager!!.currentItem = 3
                    bottomNavigationView!!.menu.findItem(R.id.nav_notification).isChecked = true
                    et_search!!.visibility = View.INVISIBLE
                }
            }
            false
        }


    }

    fun onBackPressed(view: android.view.View) {
        super.onBackPressed()
    }

    private fun initViews() {

        drawer_layout = findViewById(R.id.drawer_layout)
        et_search = findViewById(R.id.et_search)
        view_pager = findViewById(R.id.view_pager)
        bottomNavigationView = findViewById(R.id.bottom_navigation)
    }

    private fun manageClickListener() {
        val nav_view = findViewById<View>(R.id.nav_view) as NavigationView
        val header = nav_view.getHeaderView(0)
        header.findViewById<View>(R.id.lin_home).setOnClickListener { v: View? ->
            view_pager!!.currentItem = 0
            bottomNavigationView!!.menu.findItem(R.id.nav_dash).isChecked = true
            et_search!!.visibility = View.VISIBLE
            drawer_layout?.closeDrawers()
        }
        header.findViewById<View>(R.id.lin_notification).setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    applicationContext,
                    NotificationActivity::class.java
                )
            )
        }
        header.findViewById<View>(R.id.lin_booking).setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    applicationContext,
                    BookingActivity::class.java
                )
            )
        }

        header.findViewById<View>(R.id.lin_select_category).setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    applicationContext,
                    CategoryListActivity::class.java
                )
            )
        }

        header.findViewById<View>(R.id.lin_near_salon).setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    applicationContext,
                    LocationServiceActivity::class.java
                )
            )
        }
        header.findViewById<View>(R.id.lin_chnage_pass).setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    applicationContext,
                    ChangePasswordActivity::class.java
                )
            )
        }
        header.findViewById<View>(R.id.lin_deals).setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    applicationContext,
                    ServiceListActivity::class.java
                )
            )
        }

        header.findViewById<View>(R.id.txt_logout).setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    applicationContext,
                    LoginActivity::class.java
                )
            )
            finish()
        }

        header.findViewById<View>(R.id.iv_menu).setOnClickListener { v: View? ->
            drawer_layout?.closeDrawers()
        }

        header.findViewById<View>(R.id.lin_my_profile).setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    ProfileActivity::class.java
                )
            )
        }

        header.findViewById<View>(R.id.lin_privacy_policy).setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    PrivacyTermsAboutActivity::class.java
                ).putExtra("textHeading","Privacy Policy")
            )
        }

        header.findViewById<View>(R.id.lin_terms_condition).setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    PrivacyTermsAboutActivity::class.java
                ).putExtra("textHeading","Terms & Conditions")
            )
        }

        header.findViewById<View>(R.id.lin_about_us).setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    PrivacyTermsAboutActivity::class.java
                ).putExtra("textHeading","About Us")
            )
        }



        findViewById<View>(R.id.iv_profile).setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    applicationContext,
                    ProfileActivity::class.java
                )
            )
        }
        findViewById<View>(R.id.iv_menu).setOnClickListener { v: View? ->
            drawer_layout!!.openDrawer(
                Gravity.LEFT
            )
        }

    }

    fun showLocationDialog() {
        val dialog = Dialog(this@MainActivity)
        dialog.setContentView(R.layout.location_dialog)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        dialog.findViewById<View>(R.id.btn_no).setOnClickListener { v: View? -> dialog.dismiss() }
        dialog.findViewById<View>(R.id.btn_yes).setOnClickListener { v: View? -> dialog.dismiss() }
    }
}