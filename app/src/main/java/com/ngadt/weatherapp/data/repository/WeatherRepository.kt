package com.ngadt.weatherapp.data.repository

import com.ngadt.weatherapp.data.model.Weather
import com.ngadt.weatherapp.data.repository.source.WeatherDataSource
import com.ngadt.weatherapp.data.repository.source.remote.OnResultListener

class WeatherRepository(
    private val remote: WeatherDataSource.Remote,
    private val local: WeatherDataSource.Local
) : WeatherDataSource.Remote, WeatherDataSource.Local {
    override fun getWeather(listener: OnResultListener<MutableList<Weather>>, id: Int) {
        remote.getWeather(listener, id)
    }

    companion object {
        private var instance: WeatherRepository? = null

        fun getInstance(remote: WeatherDataSource.Remote, local: WeatherDataSource.Local) =
            synchronized(this) {
                instance ?: WeatherRepository(remote, local).also { instance = it }
            }
    }

    override fun getWeatherLocal(listener: OnResultListener<MutableList<Weather>>) {
        //TODO("Not yet implemented")
    }
}
