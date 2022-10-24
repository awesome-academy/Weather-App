package com.ngadt.weatherapp.screen.main

import BaseActivity
import com.ngadt.weatherapp.data.model.Weather
import com.ngadt.weatherapp.data.repository.WeatherRepository
import com.ngadt.weatherapp.data.repository.source.local.WeatherLocalDataSource
import com.ngadt.weatherapp.data.repository.source.remote.WeatherRemoteDataSource
import com.ngadt.weatherapp.databinding.ActivityMainBinding
import java.lang.Exception

class WeatherActivity : WeatherContract.View,
    BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val mWeathersPresenter by lazy {
        WeatherPresenter(
            WeatherRepository.getInstance(
                WeatherRemoteDataSource.getInstance(), WeatherLocalDataSource.getInstance()
            )
        )
    }
    private var id: Int = 0
    override fun onGetWeatherSuccess(weathers: MutableList<Weather>) {
        //TODO implement later
    }

    override fun onError(exception: Exception?) {
        //TODO implement later
    }


    override fun initData() {
        mWeathersPresenter.getWeather(id);
    }
}
