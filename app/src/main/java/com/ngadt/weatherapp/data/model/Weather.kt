package com.ngadt.weatherapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weather(
    val date: Int = 0,
    val temp: Int = 0,
    val humidity: Int = 0,
    val vision: Int = 0,
    val windSpeed: Float = 0f,
    val cloud: Int = 0,
    val status: String = "",
    val description: String = "",
    val icon: String = ""
) : Parcelable

object WeatherEntry {
    const val DATE = "dt"
    const val TEMP = "temp"
    const val HUMIDITY = "humidity"
    const val VISION = "visibility"
    const val WIND = "wind"
    const val SPEED = "speed"
    const val CLOUD = "clouds"
    const val ALL = "all"
    const val STATUS = "main"
    const val DESCRIPTION = "description"
    const val ICON = "icon"
    const val MAIN = "main"
    const val WEATHERS = "weather"
}

