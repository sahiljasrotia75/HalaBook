package com.aps.kthalabook.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R
import com.aps.kthalabook.adapter.CategoryAdapter
import com.aps.kthalabook.callbacks.CommonInterface


class CategoryListActivity : AppCompatActivity() {
    lateinit var rv_cat: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list)
        rv_cat = findViewById(R.id.rv_cat)
        rv_cat.setLayoutManager(GridLayoutManager(applicationContext, 5))

        rv_cat!!.adapter = CategoryAdapter(
            object : CommonInterface {
                override fun onItemClicked(type: String, position: Int) {
                    startActivity(Intent(applicationContext, ServiceListActivity::class.java))
                }
            })
    }
}