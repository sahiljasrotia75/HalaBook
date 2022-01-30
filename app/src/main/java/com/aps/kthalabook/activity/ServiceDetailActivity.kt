package com.aps.kthalabook.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.aps.kthalabook.callbacks.CommonInterface
import com.aps.kthalabook.model.getCategoryItem
import com.aps.kthalabook.util.Utility
import java.util.ArrayList
import android.view.Menu
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.view.ContextThemeWrapper
import com.aps.kthalabook.R
import com.aps.kthalabook.adapter.*
import kotlinx.android.synthetic.main.activity_service_detail.*





class ServiceDetailActivity : AppCompatActivity() {
    lateinit var view_pager_offers: ViewPager
    lateinit var dotsLayout: LinearLayout
    lateinit var rv_breed_service: RecyclerView
    lateinit var ic_menu: ImageView
    lateinit var rv_haicut_service: RecyclerView
    var list: MutableList<Int> = ArrayList()
    var count = 0
    lateinit var rv_cat: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_detail)
        initViews()
        setCategoryAdapter()
        setHaircutServiceAdapter()
        setBreedServiceAdapter()
        manageClickListener()
    }

    private fun manageClickListener() {
        /*    findViewById<View>(R.id.rl_view).setOnClickListener { view: View? ->
                startActivity(
                    Intent(
                        applicationContext,
                        SpecialistActivity::class.java
                    )
                )
            }*/
        findViewById<View>(R.id.btn_login).setOnClickListener { view: View? ->
            startActivity(
                Intent(
                    applicationContext,
                    MyScheduleActivity::class.java
                )
            )
        }

        findViewById<View>(R.id.ic_menu).setOnClickListener { view: View? ->
            val wrapper: Context = ContextThemeWrapper(this, R.style.PopupMenu)
            val popup = PopupMenu(wrapper, ic_menu)
            popup.menuInflater.inflate(R.menu.menu_our_booking, popup.menu)
            popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.address ->
                        startActivity(
                            Intent(
                                applicationContext,
                                PrivacyTermsAboutActivity::class.java
                            ).putExtra("textHeading","Address")
                        )
                    R.id.policies ->
                        startActivity(
                            Intent(
                                applicationContext,
                                PrivacyTermsAboutActivity::class.java
                            ).putExtra("textHeading","Privacy Policy")
                        )
                }
                true
            })
            popup.show()


    }
}

fun initViews() {
    view_pager_offers = findViewById(R.id.view_pager_offers)
    rv_cat = findViewById(R.id.rv_cat)
    rv_cat.layoutManager = (LinearLayoutManager(this, RecyclerView.HORIZONTAL, false))
    rv_haicut_service = findViewById(R.id.rv_hair_service)
    rv_breed_service = findViewById(R.id.rv_breed_service)
    ic_menu = findViewById(R.id.ic_menu)
    rv_haicut_service.layoutManager = (LinearLayoutManager(this))
    rv_breed_service.layoutManager = (LinearLayoutManager(this))

    dotsLayout = findViewById(R.id.layoutDots)
    list.add(R.drawable.nearest_image_two)
    list.add(R.drawable.nearest_image_one)
    list.add(R.drawable.nearest_image_two)
    val viewPagerAdapter = ServiceImagesAdapter(applicationContext, list)
    view_pager_offers.setAdapter(viewPagerAdapter)
    view_pager_offers.setAdapter(viewPagerAdapter)
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

fun setCategoryAdapter() {
    var list = getCategoryItem()
    rv_cat!!.adapter = OurServiceAdapter(
        object : CommonInterface {
            override fun onItemClicked(type: String, position: Int) {
                startActivity(Intent(this@ServiceDetailActivity, ServiceListActivity::class.java))
            }
        }, "", 0, context = baseContext, list = list.toMutableList()
    )
}

fun setHaircutServiceAdapter() {
    rv_haicut_service.adapter = ServiceHaircutAdapter(this)
}

fun setBreedServiceAdapter() {
    rv_breed_service.adapter = ServiceBreedAdapter(this)
}

override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_our_booking, menu)
    return true
}


fun onBackPressed(view: android.view.View) {
    super.onBackPressed()
}
}