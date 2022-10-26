package com.ngadt.weatherapp.data.repository.source

import com.ngadt.weatherapp.data.model.Weather
import com.ngadt.weatherapp.data.repository.source.remote.OnResultListener

interface WeatherDataSource {

    interface Local {
        fun getWeatherLocal(listener: OnResultListener<MutableList<Weather>>)
    }

    interface Remote {
        fun getWeather(listener: OnResultListener<MutableList<Weather>>, id: Int)
    }
}
