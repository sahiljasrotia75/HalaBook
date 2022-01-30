package com.aps.kthalabook.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R
import com.aps.kthalabook.callbacks.CommonInterface


class ServiceListAdapter(var context_c: Context, var commonInterface: CommonInterface) :
    RecyclerView.Adapter<ServiceListAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.service_list_adapter_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.rv_ser.layoutManager = LinearLayoutManager(context_c, RecyclerView.HORIZONTAL, false)
        holder.rv_ser.adapter = ServiceAdapter("VERTICAL", commonInterface)
    }

    override fun getItemCount(): Int {
        return 1
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rv_ser: RecyclerView

        init {
            rv_ser = itemView.findViewById(R.id.rv_ser)
        }
    }
}
