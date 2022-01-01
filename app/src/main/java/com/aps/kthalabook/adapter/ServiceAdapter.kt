package com.aps.kthalabook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R
import com.aps.kthalabook.callbacks.CommonInterface


class ServiceAdapter(var type: String, var commonInterface: CommonInterface) :
    RecyclerView.Adapter<ServiceAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var layout = R.layout.service_adapter_horizontal
        if (type.equals("VERTICAL", ignoreCase = true)) {
            layout = R.layout.service_adapter_item
        } else if (type.equals("VERTICAL_MATCH", ignoreCase = true)) {
            layout = R.layout.service_adapter_match
        }
        return Holder(LayoutInflater.from(parent.context).inflate(layout, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.findViewById<View>(R.id.txt_location).setOnClickListener { v: View? ->
            commonInterface.onItemClicked(
                "txt_location",
                position
            )
        }
        holder.itemView.findViewById<View>(R.id.btn_book).setOnClickListener { v: View? ->
            commonInterface.onItemClicked(
                "btn_book",
                position
            )
        }
        holder.itemView.setOnClickListener { v: View? ->
            commonInterface.onItemClicked(
                "root",
                position
            )
        }
        holder.itemView.findViewById<View>(R.id.rating_bar).setOnClickListener { v: View? ->
            commonInterface.onItemClicked(
                "rating",
                position
            )
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
