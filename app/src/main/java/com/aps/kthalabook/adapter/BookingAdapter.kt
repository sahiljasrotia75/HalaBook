package com.aps.kthalabook.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R
import com.aps.kthalabook.callbacks.CommonInterface


class BookingAdapter(var type: String, commonInterface: CommonInterface) :
    RecyclerView.Adapter<BookingAdapter.Holder>() {
    var commonInterface: CommonInterface
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var layout: Int = R.layout.booking_adapter_item
        if (type.equals("DIRECTION", ignoreCase = true)) {
            layout = R.layout.direction_booking_adapter_item
        }
        return Holder(
            LayoutInflater.from(parent.context)
                .inflate(layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener { v: View? ->
            commonInterface.onItemClicked("", position)
        }
        holder.itemView.findViewById<View>(R.id.btn_book).setOnClickListener { v: View? ->
            commonInterface.onItemClicked("Direction", position )
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)

    init {
        this.commonInterface = commonInterface
    }
}
