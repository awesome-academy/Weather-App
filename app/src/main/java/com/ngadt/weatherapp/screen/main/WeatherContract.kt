package com.ngadt.weatherapp.screen.main

import BasePresenter
import com.ngadt.weatherapp.data.model.Weather
import java.lang.Exception

class WeatherContract {
    /**
     * View
     */
    interface View {
        fun onGetWeatherSuccess(movies: MutableList<Weather>)
        fun onError(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun getWeather(id: Int)
    }
}
