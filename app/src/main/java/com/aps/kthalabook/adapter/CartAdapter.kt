package com.aps.kthalabook.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R

class CartAdapter : RecyclerView.Adapter<CartAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.cart_adapter_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {}
    override fun getItemCount(): Int {
        return 2
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)
}