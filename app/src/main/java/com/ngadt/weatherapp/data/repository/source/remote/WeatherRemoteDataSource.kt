package com.ngadt.weatherapp.data.repository.source.remote

import com.ngadt.weatherapp.data.model.Weather
import com.ngadt.weatherapp.data.model.WeatherEntry
import com.ngadt.weatherapp.data.repository.source.WeatherDataSource
import com.ngadt.weatherapp.data.repository.source.remote.fetchjson.GetJsonFromUrl
import com.ngadt.weatherapp.utils.Constant

class WeatherRemoteDataSource : WeatherDataSource.Remote {
    override fun getWeather(listener: OnResultListener<MutableList<Weather>>, id: Int) {
        GetJsonFromUrl(
            urlString = Constant.BASE_URL + Constant.BASE_ID + id,
            keyEntity = WeatherEntry.WEATHERS,
            listener = listener
        )
    }

    companion object {
        private var instance: WeatherRemoteDataSource? = null

        fun getInstance() = synchronized(this) {
            instance ?: WeatherRemoteDataSource().also { instance = it }
        }
    }
}
