package com.ngadt.weatherapp.data.repository.source.local

import com.ngadt.weatherapp.data.model.Weather
import com.ngadt.weatherapp.data.repository.source.WeatherDataSource
import com.ngadt.weatherapp.data.repository.source.remote.OnResultListener

class WeatherLocalDataSource : WeatherDataSource.Local {
    override fun getWeatherLocal(listener: OnResultListener<MutableList<Weather>>) {
        //TODO implement later
    }

    companion object {
        private var instance: WeatherLocalDataSource? = null

        fun getInstance() = synchronized(this) {
            instance ?: WeatherLocalDataSource().also { instance = it }
        }
    }
}
