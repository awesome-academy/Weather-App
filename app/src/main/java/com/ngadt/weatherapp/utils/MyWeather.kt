package com.ngadt.weatherapp.utils

import java.text.SimpleDateFormat
import java.util.*

object MyWeather {

    fun formatDate(date: Long): String {
        val dat = Date(date * 1000)
        val formatDate = SimpleDateFormat("E, MMM dd HH:mm")
        val dateFormated = formatDate.format(dat)
        return dateFormated
    }

    fun formatDay(date: Long): String {
        val dat = Date(date * 1000)
        val formatDate = SimpleDateFormat("E")
        val dateFormated = formatDate.format(dat)
        val calender = Calendar.getInstance()
        calender.time = dat
        val day = calender.get(Calendar.DAY_OF_WEEK)
        val dateNow = Calendar.getInstance()
        val dayNow = dateNow.get(Calendar.DAY_OF_WEEK)
        val dayFormated = when (day) {
            dayNow -> Constant.TODAY
            else -> dateFormated
        }
        return dayFormated
    }

    fun formatDateDay(date: Long): String {
        val dat = Date(date * 1000)
        val formatDate = SimpleDateFormat("dd/MM")
        val dateFormated = formatDate.format(dat)
        return dateFormated
    }

    fun checkHourCurrent(date: Long): Boolean {
        val dat = Date(date * 1000)
        val calender = Calendar.getInstance()
        calender.time = dat
        val hour = calender.get(Calendar.HOUR_OF_DAY)
        val dateNow = Calendar.getInstance()
        val hourNow = dateNow.get(Calendar.HOUR_OF_DAY)
        if (hour == hourNow || (hourNow - hour) < 3) {
            return true
        }
        return false
    }

    fun formatHour(date: Long, position: Int): String {
        val dat = Date(date * 1000)
        val calender = Calendar.getInstance()
        calender.time = dat
        val hour = calender.get(Calendar.HOUR_OF_DAY)
        val dateOfDay = calender.get(Calendar.DAY_OF_YEAR)
        val dateNow = Calendar.getInstance()
        val dates = dateNow.get(Calendar.DAY_OF_YEAR)
        val formatDate = SimpleDateFormat("HH:mm")
        val dateFormated = formatDate.format(dat)
        if (position == 0) {
            return Constant.NOW
        }
        if (dateOfDay != dates && hour >= 0 && hour < 3) {
            return formatDateDay(date)
        } else {
            return dateFormated
        }
    }
}
