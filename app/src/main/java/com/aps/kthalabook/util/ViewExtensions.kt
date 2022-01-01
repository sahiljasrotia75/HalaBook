package com.aps.kthalabook.util

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat
import androidx.core.widget.NestedScrollView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.prolificinteractive.materialcalendarview.MaterialCalendarView

import java.text.ParseException
import java.text.SimpleDateFormat

/**
 * Created by sahil.
 */
fun View.makeGone() {
    visibility = View.GONE
}

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeInvisible() {
    visibility = View.INVISIBLE
}

fun View.disable() {
    isEnabled = false
}

fun View.enable() {
    isEnabled = true
}

fun View.makeVisibleOrGone(value: Boolean) {
    visibility = if (value) View.VISIBLE
                 else View.GONE
}

fun View.makeVisibleOrInvisible(value: Boolean) {
    visibility = if (value) View.VISIBLE
    else View.INVISIBLE
}

fun View.makeGoneOrVisible(value: Boolean) {
    visibility = if (!value) View.VISIBLE
    else View.GONE
}

fun Context.toast(context: Context, msg: String){
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}

fun Context.toast(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun EditText.textWatcher(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        var timer: CountDownTimer? = null

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun afterTextChanged(editable: Editable?) {
            timer?.cancel()
            timer = object : CountDownTimer(100, 500) {
                override fun onTick(millisUntilFinished: Long) {}
                override fun onFinish() {
                    afterTextChanged.invoke(editable.toString())
                }
            }.start()
        }
    })
}

fun RecyclerView.onScrolledToEnd(recyclerScrollListener: RecyclerScrollListener){
    this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            val mLayoutManager = (this@onScrolledToEnd.layoutManager as LinearLayoutManager)
            val visibleItemCount = mLayoutManager.childCount
            val totalItemCount = mLayoutManager.itemCount
            val firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition()
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                && firstVisibleItemPosition >= 0&& dy>0) {
                recyclerScrollListener.onScrollToEnd()
            }
        }
    })
}

fun MaterialCalendarView.addDecoratorToCalendarView(context: Context?, date: CalendarDay){
    this.removeDecorators()
    this.addDecorator(object : DayViewDecorator {
        override fun shouldDecorate(day: CalendarDay?): Boolean {
            return day == date
        }
        override fun decorate(view: DayViewFacade?) {
            view?.setBackgroundDrawable(context?.let { ContextCompat.getDrawable(it, R.drawable.ic_calender_decorator) }!!)
        }
    })
}

@SuppressLint("SimpleDateFormat")
fun TextView.convertToSpecificDateFormat(date: CalendarDay){
    var input = ""+date.year+"-"+date.month+"-"+date.day
    try {
        var spf = SimpleDateFormat("yyyy-MM-dd")
        val newDate = spf.parse(input)
        spf = SimpleDateFormat("MMMM dd, yyyy")
        input = spf.format(newDate!!)
        this.text = input
    } catch (e: ParseException) {
        Log.e("", "" + e)
    }
}

@SuppressLint("SimpleDateFormat")
fun TextView.convertToSpecificDateFormatMonth(date: CalendarDay){
    var input = ""+date.year+"-"+date.month+"-"+date.day
    try {
        var spf = SimpleDateFormat("yyyy-MM-dd")
        val newDate = spf.parse(input)
        spf = SimpleDateFormat("MMMM, yyyy")
        input = spf.format(newDate!!)
        this.text = input
    } catch (e: ParseException) {
        Log.e("", "" + e)
    }
}

fun TextView.setTextFollowStatus(followRequestType: String?){
    makeVisible()
    when (followRequestType) {
        FollowRequestType.NOT_SUPPORTING.name -> text = "Follow"
        FollowRequestType.REQUESTED.name -> text = "Requested"
        FollowRequestType.SUPPORTING.name -> makeGone()
    }
}

fun TextView.setTextFollowStatusList(followRequestType: String?){
    when (followRequestType) {
        FollowRequestType.NOT_SUPPORTING.name -> text = "Follow Back"
        FollowRequestType.REQUESTED.name -> text = "Requested"
        FollowRequestType.SUPPORTING.name -> text = "Unfollow"
    }
}

fun NestedScrollView.onScrolledToEnd(recyclerScrollListener: RecyclerScrollListener){
    this.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
        if (scrollY == v!!.getChildAt(0).measuredHeight - v.measuredHeight) {
            recyclerScrollListener.onScrollToEnd()
        }
    })
}

fun TextView.afterTextChangedDelayed(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        var timer: CountDownTimer? = null

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun afterTextChanged(editable: Editable?) {
            timer?.cancel()
            timer = object : CountDownTimer(1000, 1000) {
                override fun onTick(millisUntilFinished: Long) {}
                override fun onFinish() {
                    afterTextChanged.invoke(editable.toString())
                }
            }.start()
        }
    })
}

fun isValidEmail(email: String): Boolean {
    return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun EditText.afterTextChangedEdit(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        var timer: CountDownTimer? = null
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun afterTextChanged(editable: Editable?) {
            timer?.cancel()
            timer = object : CountDownTimer(700, 700) {
                override fun onTick(millisUntilFinished: Long) {}
                override fun onFinish() {
                    afterTextChanged.invoke(editable.toString())
                }
            }.start()
        }
    })
}

fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit) {
    val safeClickListener = SafeClickListener {
        onSafeClick(it)
    }
    setOnClickListener(safeClickListener)
}

fun Activity.hideSoftKeyboard(view: View?) {
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

/*fun Activity.refreshNotificationToken(){
    FirebaseMessaging.getInstance().token
        .addOnCompleteListener(object : OnCompleteListener<String?> {
            override fun onComplete(@NonNull task: Task<String?>) {
                if (!task.isSuccessful) {
                    Timber.w( task.exception,
                        this.javaClass.name,
                        "Fetching FCM registration token failed",
                    )
                    return
                }
                // Get new FCM registration token
                val token: String = task.result.toString()
                Constants.DEVICE_ID = token
                // Log and toast
                Timber.e( "${this.javaClass.name}  : $token"  )
            }
        })
}*/
enum class FollowRequestType {
    REQUESTED,
    SUPPORTING,
    NOT_SUPPORTING
}

/*

fun View.setOnSafeTouchListener(onSafeTouch: (View) -> Unit) {
    val safeTouchListener = SafeOnTouchListener{
        onSafeTouch(it)
    }
    setOnTouchListener(safeTouchListener)
}*/
