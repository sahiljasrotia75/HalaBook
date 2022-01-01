package com.aps.kthalabook.util

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.Html
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.aps.kthalabook.R

class  Utility {
    fun  addBottomDots(size: Int, currentPage: Int, dotsLayout: LinearLayout, context: Context) {
        val mTxvDotsArray = arrayOfNulls<TextView>(size)
        dotsLayout.removeAllViews()
        for (i in mTxvDotsArray.indices) {
            mTxvDotsArray[i] = TextView(context)
            mTxvDotsArray[i]!!.text = Html.fromHtml("&#8226;")
            mTxvDotsArray[i]!!.textSize = 35f
            mTxvDotsArray[i]!!.setTextColor(context.resources.getColor(R.color.light_gray_dot))
            dotsLayout.addView(mTxvDotsArray[i])
        }
        if (mTxvDotsArray.size > 0) mTxvDotsArray[currentPage]!!
            .setTextColor(context.resources.getColor(R.color.dark_cyan))
    }

    fun ratingDialog(activity: Activity?) {
        val dialog = Dialog(activity!!)
        dialog.setContentView(R.layout.rating_dialog)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        dialog.findViewById<View>(R.id.btn_submit)
            .setOnClickListener { v: View? -> dialog.dismiss() }
    }

    fun addDigitInFront(value: Int): String {
        return if (value < 10) "0$value" else value.toString()
    }
}