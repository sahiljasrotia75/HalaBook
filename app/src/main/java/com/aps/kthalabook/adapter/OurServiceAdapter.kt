package com.aps.kthalabook.adapter


import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R
import com.aps.kthalabook.callbacks.CommonInterface
import com.aps.kthalabook.model.CategoryModel

class OurServiceAdapter(
    commonInterface: CommonInterface,
    type: String,
    s_pos: Int,
    context: Context,
    var list: MutableList<CategoryModel>

) :
    RecyclerView.Adapter<OurServiceAdapter.Holder>() {

    var commonInterface: CommonInterface
    var type=""
    var s_pos =0
    private var currentSelection=0


    lateinit var context :Context ;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.our_service_adapter_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        if (list[position].selected){
            holder.tvName.setTextColor(Color.parseColor("#FFAC98"));
        }else{
            holder.tvName.setTextColor(Color.parseColor("#8A8080"));
        }

      //  holder.iv_cat.setImageResource(list[position].image)
        holder.tvName.text = (list[position].text)
        holder.itemView.setOnClickListener { v: View? ->
                list[position].selected = !list[position].selected
                notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvName: TextView = itemView.findViewById(R.id.tvName)

    }

    init {
        this.commonInterface = commonInterface
        this.type = type
        this.s_pos = s_pos
        this.context = context
    }


}
