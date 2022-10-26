package com.ngadt.weatherapp.screen.main

import com.ngadt.weatherapp.data.model.Weather
import com.ngadt.weatherapp.data.repository.WeatherRepository
import com.ngadt.weatherapp.data.repository.source.remote.OnResultListener

class WeatherPresenter internal constructor(private val weatherRepository: WeatherRepository) :
    WeatherContract.Presenter {

    private var mView: WeatherContract.View? = null


    override fun onStart() {
    }

    override fun onStop() {
    }

    override fun setView(view: WeatherContract.View?) {
        this.mView = view
    }

    override fun getWeather(id: Int) {
        weatherRepository.getWeather(object : OnResultListener<MutableList<Weather>> {
            override fun onSuccess(data: MutableList<Weather>) {
                mView?.onGetWeatherSuccess(data)
            }

            override fun onError(exception: Exception?) {
                mView?.onError(exception)
            }

        }, id)
    }

}
