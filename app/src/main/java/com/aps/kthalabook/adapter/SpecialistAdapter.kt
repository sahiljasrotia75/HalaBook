package com.aps.kthalabook.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R
import com.aps.kthalabook.model.SpecialistModel
import java.lang.Exception
import java.util.ArrayList


class SpecialistAdapter(var list: MutableList<SpecialistModel>) :
    RecyclerView.Adapter<SpecialistAdapter.Holder>() {
    private var currentSelection=0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.specialist_adapter_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        if (position == currentSelection) {
            holder.itemView.findViewById<View>(R.id.stroke_view).visibility = View.VISIBLE
            holder.itemView.findViewById<View>(R.id.iv_tick).visibility = View.VISIBLE
        } else {
            holder.itemView.findViewById<View>(R.id.stroke_view).visibility = View.GONE
            holder.itemView.findViewById<View>(R.id.iv_tick).visibility = View.GONE
        }
        try {
            holder.itemView.setOnClickListener { v: View? ->
                currentSelection=position
                notifyDataSetChanged()
            }
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
