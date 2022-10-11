package com.madtitan94.expmgr.utils

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class DateUtils {

    companion object{

    public fun  getCurrentTimeStamp():String{
        return SimpleDateFormat("yyyy-MM-dd HH:mm").format(Calendar.getInstance().time).toString()
    }
    }
}