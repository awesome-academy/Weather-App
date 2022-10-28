package com.ngadt.weatherapp.utils

import com.ngadt.weatherapp.BuildConfig

object Constant {
    const val BASE_URL = "https://api.openweathermap.org/data/2.5/weather?"
    const val BASE_DAY_URL = "https://api.openweathermap.org/data/2.5/forecast/daily?"
    const val BASE_HOUR_URL = "https://api.openweathermap.org/data/2.5/forecast?"
    const val BASE_ID = "id="
    const val BASE_API_KEY = "&appid=" + BuildConfig.API_KEY
    const val BASE_UNIT = "&units=metric"
    const val BASE_URL_IMAGE = "http://openweathermap.org/img/w/"
    const val DV_HUMIDITY = " %"
    const val DV_SPEED = " km/h"
    const val DV_VISION = " km"
    const val DV_IMG = ".png"
    const val TODAY = "Today"
    const val NOW = "Now"
}
