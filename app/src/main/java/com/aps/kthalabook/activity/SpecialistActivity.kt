package com.aps.kthalabook.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R
import com.aps.kthalabook.adapter.SpecialistAdapter

import java.util.ArrayList


class SpecialistActivity : AppCompatActivity() {
    lateinit var rv_specialist: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specialist)
        initViews()
        setSpecialistAdapter()
    }

    private fun setSpecialistAdapter() {
        val list: MutableList<String> = ArrayList()
        list.add("https://picsum.photos/200/300")
        list.add("https://picsum.photos/200/300?grayscale")
        list.add("https://picsum.photos/200/300/?blur")
        list.add("https://picsum.photos/200/300")
        list.add("https://picsum.photos/200/300?grayscale")
        list.add("https://picsum.photos/200/300/?blur")
        list.add("https://picsum.photos/200/300")
        list.add("https://picsum.photos/200/300?grayscale")
        list.add("https://picsum.photos/200/300/?blur")
        list.add("https://picsum.photos/200/300")
        list.add("https://picsum.photos/200/300?grayscale")
        list.add("https://picsum.photos/200/300/?blur")
        val specialistAdapter = SpecialistAdapter(list)
        rv_specialist!!.adapter = specialistAdapter
    }

    private fun initViews() {
        rv_specialist = findViewById(R.id.rv_specialist)
        rv_specialist.setLayoutManager(GridLayoutManager(applicationContext, 3))
    }
}