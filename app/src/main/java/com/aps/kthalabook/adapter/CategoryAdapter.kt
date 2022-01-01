package com.aps.kthalabook.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R
import com.aps.kthalabook.callbacks.CommonInterface

class CategoryAdapter(commonInterface: CommonInterface) :
    RecyclerView.Adapter<CategoryAdapter.Holder>() {
    var commonInterface: CommonInterface
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.category_adapter_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener { v: View? ->
            commonInterface.onItemClicked(
                "",
                position
            )
        }
    }

    override fun getItemCount(): Int {
        return 100
    }

     class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)

    init {
        this.commonInterface = commonInterface
    }
}
