package com.aps.kthalabook.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R
import com.aps.kthalabook.adapter.CategoryAdapter
import com.aps.kthalabook.callbacks.CommonInterface
import com.aps.kthalabook.model.getCategoryItem


class CategoryListActivity : AppCompatActivity() {
    lateinit var rv_cat: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list)
        rv_cat = findViewById(R.id.rv_cat)
        rv_cat.setLayoutManager(GridLayoutManager(applicationContext, 4))
        var list = getCategoryItem()
        rv_cat!!.adapter = CategoryAdapter(

            object : CommonInterface {
                override fun onItemClicked(type: String, position: Int) {
                    startActivity(Intent(applicationContext, ServiceListActivity::class.java))
                }
            },
            type = "CategoryList",
            s_pos = 0,
            context = baseContext,
            list = list.toMutableList())

    }
    fun onBackPressed(view: android.view.View) {
        super.onBackPressed()
    }

    fun selectSpecialist(view: android.view.View) {
        startActivity(Intent(applicationContext , MainActivity::class.java))
    }
}