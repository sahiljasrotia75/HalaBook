package com.aps.kthalabook.adapter


import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R
import com.aps.kthalabook.callbacks.CommonInterface
import com.aps.kthalabook.model.CategoryModel

class CategoryAdapter(
    commonInterface: CommonInterface,
    type: String,
    s_pos: Int,
    context: Context,
    var list: MutableList<CategoryModel>

) :
    RecyclerView.Adapter<CategoryAdapter.Holder>() {

    var commonInterface: CommonInterface
    var type=""
    var s_pos =0
    private var currentSelection=0


    lateinit var context :Context ;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.category_adapter_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        if (list[position].selected){
                holder.iv_cat.setTint(R.color.secondry_color)
            }else{
                holder.iv_cat.setTint(R.color.gray)
            }
        if (type=="Home"){
            if (position == currentSelection) {
                holder.iv_cat.setTint(R.color.secondry_color)
            } else {
                holder.iv_cat.setTint(R.color.gray)
            }
        }

        holder.iv_cat.setImageResource(list[position].image)
        holder.txt_Name.text = (list[position].text)
        holder.itemView.setOnClickListener { v: View? ->
           // commonInterface.onItemClicked("", position)
            if (type=="Home"){
                currentSelection=position
                notifyDataSetChanged()
            }else{
                list[position].selected = !list[position].selected
                notifyItemChanged(position)
            }

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

     class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
         var iv_cat: ImageView = itemView.findViewById(R.id.iv_cat)
         var txt_Name: TextView = itemView.findViewById(R.id.txtName)

     }

    init {
        this.commonInterface = commonInterface
        this.type = type
        this.s_pos = s_pos
        this.context = context
    }

    fun ImageView.setTint(@ColorRes colorRes: Int) {
        ImageViewCompat.setImageTintList(this, ColorStateList.valueOf(
            ContextCompat.getColor(context, colorRes)))
    }

}
