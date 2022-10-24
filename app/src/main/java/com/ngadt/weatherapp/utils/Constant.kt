package com.ngadt.weatherapp.utils

import com.ngadt.weatherapp.BuildConfig

object Constant {
    const val BASE_URL = "https://api.openweathermap.org/data/2.5/weather?"
    const val BASE_ID = "id="
    const val BASE_API_KEY = "&appid=" + BuildConfig.API_KEY
}
