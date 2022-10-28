package com.ngadt.weatherapp.screen.main

import BasePresenter
import com.ngadt.weatherapp.data.model.Weather
import java.lang.Exception

class WeatherContract {
    /**
     * View
     */
    interface View {
        fun onGetWeatherSuccess(weatherList: MutableList<Weather>)
        fun onErrorWeather(exception: Exception?)
        fun onGetDaySuccess(dayList: MutableList<Weather>)
        fun onErrorDay(exception: Exception?)
        fun onGetHourSuccess(hourList: MutableList<Weather>)
        fun onErrorHour(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun getWeather(id: Int)
        fun getDayWeather(id: Int)
        fun getHourWeather(id: Int)
    }
}
