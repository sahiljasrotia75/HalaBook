package com.aps.kthalabook.model

data class ScheduleModelItem(
    var text:String,
    var selected:Boolean,
)

fun getScheduleSelectionItem():List<ScheduleModelItem>{
    return mutableListOf(
        ScheduleModelItem(
            text = "09:00",
            selected = false
        ),
        ScheduleModelItem(
            text = "10:00",
            selected = false,
        ),
        ScheduleModelItem(
            text = "11:00",
            selected = false
        ),
        ScheduleModelItem(
            text = "12:00",
            selected = false
        ),
        ScheduleModelItem(
            text = "13:00",
            selected = false
        ),
        ScheduleModelItem(
            text = "14:00",
            selected = false
        ),
        ScheduleModelItem(
            text = "15:00",
            selected = false
        ),
        ScheduleModelItem(
            text = "16:00",
            selected = true
        ),
        ScheduleModelItem(
            text = "17:00",
            selected = false
        ),
        ScheduleModelItem(
            text = "18:00",
            selected = false
        ),
        ScheduleModelItem(
            text = "19:00",
            selected = false
        ),
        ScheduleModelItem(
            text = "20:00",
            selected = false
        )
    )
}