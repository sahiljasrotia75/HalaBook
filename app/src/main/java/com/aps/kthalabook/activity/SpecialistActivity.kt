package com.aps.kthalabook.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R
import com.aps.kthalabook.adapter.SpecialistAdapter
import com.aps.kthalabook.model.getSpecialistItem


class SpecialistActivity : AppCompatActivity() {
    lateinit var rv_specialist: RecyclerView
    lateinit var btnDone: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specialist)
        initViews()
        setSpecialistAdapter()
    }

    private fun setSpecialistAdapter() {
        val list = getSpecialistItem()
        val specialistAdapter = SpecialistAdapter(list.toMutableList())
        rv_specialist!!.adapter = specialistAdapter
    }

    private fun initViews() {
        rv_specialist = findViewById(R.id.rv_specialist)
        btnDone = findViewById(R.id.btn_done)
        rv_specialist.setLayoutManager(GridLayoutManager(applicationContext, 3))

        btnDone.setOnClickListener {
            startActivity(
                Intent(this, MyCartActivity::class.java)
            )
        }
    }

    fun onBackPressed(view: android.view.View) {
        super.onBackPressed()
    }
}