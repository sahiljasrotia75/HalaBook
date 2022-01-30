package com.aps.kthalabook.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.aps.kthalabook.R
import com.aps.kthalabook.adapter.MyScheduleAdapter
import com.aps.kthalabook.databinding.ActivityMyScheduleBinding
import com.aps.kthalabook.model.ScheduleModelItem
import com.aps.kthalabook.model.getScheduleSelectionItem
import com.aps.kthalabook.util.Utility
import com.aps.kthalabook.util.addDecoratorToCalendarView
import com.aps.kthalabook.util.convertToSpecificDateFormat
import com.aps.kthalabook.util.convertToSpecificDateFormatMonth
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.CalendarMode

class MyScheduleActivity : AppCompatActivity(), MyScheduleListener,
    MyScheduleAdapter.ScheduleSelectionListener {
    lateinit var bindingObj: ActivityMyScheduleBinding
    var mSelectedDate = ""
    var mStartDate = ""
    var mEndDate = ""
    var selectedDay: CalendarDay? = null
    var an: MyScheduleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_schedule)
        if (this::bindingObj.isInitialized.not()) {
            bindingObj = DataBindingUtil.setContentView(this, R.layout.activity_my_schedule)
            initCalendar()
            initialization()
            initClickEvents()
            // apiObserver()
        }

    }

    private fun initClickEvents() {
        bindingObj.btnSpe.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    SpecialistActivity::class.java
                )
            )
        }
    }


    fun initialization() {
        bindingObj.apply {
            listener = this@MyScheduleActivity
            // mViewModel = ViewModelProviders.of(this@MyScheduleFragment, viewModelFactory).get(MyScheduleViewModel::class.java)
            //  initBaseViewModel(mViewModel)

            //  if (list.size>0) list.clear()
            setNearbyFilterListData()
            //   callScheduleListApi()
        }
    }

    private fun setNearbyFilterListData() {
        val list = getScheduleSelectionItem()
        bindingObj.rvMySchedules.layoutManager = GridLayoutManager(this, 4)
        an = MyScheduleAdapter(this, list.toMutableList())
        bindingObj.rvMySchedules.adapter = an
    }

    private fun initCalendar() {
        bindingObj.calendarViewMySchedule.apply {
            clearSelection()
            addDecoratorToCalendarView(this@MyScheduleActivity, CalendarDay.today())
            bindingObj.exMonthYearText.convertToSpecificDateFormat(CalendarDay.today())
            selectedDate = CalendarDay.today()
            currentDate = CalendarDay.today()
            mSelectedDate =
                "${selectedDate?.year}-${Utility().addDigitInFront(selectedDate?.month!!)}-${
                    Utility().addDigitInFront(selectedDate?.day!!)
                }"
            selectedDay = CalendarDay.today()
            initializeDates(CalendarDay.today())
            setOnDateChangedListener { widget, date, selected ->
                addDecoratorToCalendarView(this@MyScheduleActivity, date)
                bindingObj.exMonthYearText.convertToSpecificDateFormat(date)
                mSelectedDate = "${date.year}-${Utility().addDigitInFront(date.month)}-${
                    Utility().addDigitInFront(date.day)
                }"
                initializeDates(date)
                selectedDay = date
                //inflateSelectedDayData()
            }

            setOnMonthChangedListener { widget, date ->
                initializeDates(date)
                // callScheduleListApi()
                bindingObj.exMonthYearText.convertToSpecificDateFormatMonth(date)
            }

            //  val dateSel = args.dateSelected

//            if (dateSel.isNotEmpty()) {
//                val date = dateSel.split("T")[0]
//                mSelectedDate = date
//                val currentDay = CalendarDay.from(date.split("-")[0].toInt(), date.split("-")[1].toInt(), date.split("-")[2].toInt())
//                selectedDay = currentDay
//                currentDate = currentDay
//            }
        }
    }

    private fun initializeDates(date: CalendarDay) {
        mStartDate = "${date.year}-${Utility().addDigitInFront(date.month)}-01"
        mEndDate =
            if (date.month < 12) "${date.year}-${Utility().addDigitInFront(date.month + 1)}-01"
            else "${date.year}-01-01"
    }

    override fun onSelection(item: ScheduleModelItem, position: Int) {
        item.selected = !item.selected
        an?.notifyItemChanged(position)
    }

/*    private fun inflateSelectedDayData(){
        bindingObj.apply {
            val mList = scheduleDetails.distinctBy { it.date }
            calendarViewMySchedule.apply {
                clearSelection()
                removeDecorators()
                selectedDate = selectedDay
                addDecoratorToCalendarView(requireContext(), selectedDay!!)
            }
            Utility.addDotsToCalendarView(calendarViewMySchedule, mList as ArrayList<ScheduleListResponse.Data.ScheduleDetail>)
            if (list.size>0)list.clear()
            if (edtSearchSchedule.text.isNullOrEmpty() && !(mList.firstOrNull { it.date == mSelectedDate })?.scheduleList.isNullOrEmpty()){
                list.addAll((mList.firstOrNull { it.date == mSelectedDate })!!.scheduleList)
            } else if(edtSearchSchedule.text.isNotEmpty()){
                mList.forEach {
                    list.addAll(it.scheduleList)
                }
            }
            initRecyclerView(list)
            errorMsgTxt.makeGoneOrVisible(list.isNotEmpty())
        }
    }*/

    override fun updateCalendarMode() {
        bindingObj.apply {
            if (calendarViewMySchedule.calendarMode == CalendarMode.WEEKS)
                calendarViewMySchedule.state().edit().setCalendarDisplayMode(CalendarMode.MONTHS)
                    .commit()
            else calendarViewMySchedule.state().edit().setCalendarDisplayMode(CalendarMode.WEEKS)
                .commit()
        }

    }

    override fun goToNext() {
        bindingObj.calendarViewMySchedule.goToNext()
    }

    override fun goToPrevious() {
        bindingObj.calendarViewMySchedule.goToPrevious()
    }

    fun onBackPressed(view: android.view.View) {
        super.onBackPressed()
    }

    fun selectSpecialist(view: View) {
        startActivity(
            Intent(
                applicationContext,
                SpecialistActivity::class.java
            )
        )
    }


}

interface MyScheduleListener {
    fun updateCalendarMode()
    fun goToNext()
    fun goToPrevious()
}