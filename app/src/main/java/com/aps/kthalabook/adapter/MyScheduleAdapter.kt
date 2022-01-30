package com.aps.kthalabook.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.activity.MyScheduleListener
import com.aps.kthalabook.databinding.ItemHaircutScheduleBinding
import com.aps.kthalabook.model.ScheduleModelItem

class MyScheduleAdapter (
            val listener:ScheduleSelectionListener,
            val items:MutableList<ScheduleModelItem>
        ): RecyclerView.Adapter<MyScheduleAdapter.MyScheduleViewHolder>() {


    class MyScheduleViewHolder(val binding:ItemHaircutScheduleBinding) : RecyclerView.ViewHolder(binding.root)

    fun getCurrentItems():MutableList<ScheduleModelItem>{
        return items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyScheduleViewHolder {
        return MyScheduleViewHolder(ItemHaircutScheduleBinding.inflate(LayoutInflater.from(parent.context),
                parent,false))
    }

    override fun onBindViewHolder(holder: MyScheduleViewHolder, position: Int) {
        holder.binding.item=items[position]
        holder.binding.listener=listener
        holder.binding.position=position
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    interface ScheduleSelectionListener: MyScheduleListener {
        fun onSelection(item:ScheduleModelItem, position: Int)
    }

}