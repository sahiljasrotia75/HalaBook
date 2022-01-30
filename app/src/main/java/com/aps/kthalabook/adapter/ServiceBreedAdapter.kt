package com.aps.kthalabook.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R

class ServiceBreedAdapter(
    var context: Context
) :
    RecyclerView.Adapter<ServiceBreedAdapter.Holder>() {

    private var currentSelection = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_breed_service, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        if (position == currentSelection) {
            holder.rl_tick.visibility= View.VISIBLE
            holder.rl_get.visibility=View.GONE
        } else {
            holder.rl_tick.visibility= View.GONE
            holder.rl_get.visibility=View.VISIBLE
        }

        holder.rl_get.setOnClickListener { v: View? ->
            currentSelection = position
            notifyDataSetChanged()

        }
    }

    override fun getItemCount(): Int {
        return 3
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rl_get: RelativeLayout = itemView.findViewById(R.id.rl_get)
        var rl_tick: RelativeLayout = itemView.findViewById(R.id.rl_tick)

    }


}