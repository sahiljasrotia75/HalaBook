package com.aps.kthalabook.util

import android.R.anim
import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.aps.kthalabook.R
import com.aps.kthalabook.model.ScheduleModelItem




@BindingAdapter("nearbySelection","selectionText")
fun ConstraintLayout.setNearbySelection(item:ScheduleModelItem, textView:TextView){
    if (item.selected){
        setBackgroundResource(R.drawable.secondry_btn_bg)
        textView.setTextColor(ContextCompat.getColor(textView.context,R.color.white))
    }else{
        setBackgroundResource(R.drawable.item_unselection_bg)
        textView.setTextColor(ContextCompat.getColor(textView.context,R.color.black_500))
    }
}


