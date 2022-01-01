package com.aps.kthalabook.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R
import java.lang.Exception
import java.util.ArrayList


class SpecialistAdapter(list: List<String>) :
    RecyclerView.Adapter<SpecialistAdapter.Holder>() {
    var list: List<String> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.specialist_adapter_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        try {
            holder.itemView.setOnClickListener { v: View? -> }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)

    init {
        this.list = list
    }
}
