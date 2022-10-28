package com.ngadt.weatherapp.screen.main

import BaseActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.ngadt.weatherapp.data.model.Weather
import com.ngadt.weatherapp.data.repository.WeatherRepository
import com.ngadt.weatherapp.data.repository.source.local.WeatherLocalDataSource
import com.ngadt.weatherapp.data.repository.source.remote.WeatherRemoteDataSource
import com.ngadt.weatherapp.databinding.ActivityMainBinding
import com.ngadt.weatherapp.screen.main.adapter.DayAdapter
import com.ngadt.weatherapp.screen.main.adapter.HourAdapter
import com.ngadt.weatherapp.utils.Constant
import com.ngadt.weatherapp.utils.MyWeather
import java.lang.Exception

private const val HOUR_COUNT = 8

class WeatherActivity : WeatherContract.View,
    BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate), OnClickListener {

    private var currentWeather = Weather()
    private var dayAdapter = DayAdapter(this::clickDayItem)
    private var hourAdapter = HourAdapter()
    private var hours = mutableListOf<Weather>()

    private val mWeathersPresenter by lazy {
        WeatherPresenter(
            WeatherRepository.getInstance(
                WeatherRemoteDataSource.getInstance(), WeatherLocalDataSource.getInstance()
            )
        )
    }
    private var id: Int = 0
    override fun onGetWeatherSuccess(weathers: MutableList<Weather>) {
        currentWeather = weathers[0]
        initView()
    }

    override fun onErrorWeather(exception: Exception?) {
        Toast.makeText(this@WeatherActivity, exception?.message, Toast.LENGTH_SHORT).show()
    }

    override fun onGetDaySuccess(dayList: MutableList<Weather>) {
        dayAdapter.setDataToList(dayList)
        binding.recyclerDay.adapter = dayAdapter
        binding.recyclerDay.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onErrorDay(exception: Exception?) {
        Toast.makeText(this@WeatherActivity, exception?.message, Toast.LENGTH_SHORT).show()
    }

    override fun onGetHourSuccess(hourList: MutableList<Weather>) {
        val currentPositon = hourCurrentPosition(hourList)
        for (i in 0 until HOUR_COUNT) {
            hours.add(hourList[i + currentPositon])
        }
        hourAdapter.setDataToList(hours)
        binding.recyclerHour.adapter = hourAdapter
        binding.recyclerHour.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onErrorHour(exception: Exception?) {
        Toast.makeText(this@WeatherActivity, exception?.message, Toast.LENGTH_SHORT).show()
    }

    override fun initData() {
        mWeathersPresenter.getWeather(id)
        mWeathersPresenter.getDayWeather(id)
        mWeathersPresenter.getHourWeather(id)
        mWeathersPresenter.setView(this)
    }

    fun initView() {
        binding.btnAdd.setOnClickListener(this)
        binding.location.setText(currentWeather.location)
        val iconUrl = Constant.BASE_URL_IMAGE + currentWeather.icon + Constant.DV_IMG
        Glide.with(this).load(iconUrl).into(binding.imgSun)
        binding.date.setText(MyWeather.formatDate(currentWeather.date))
        binding.temp.setText(currentWeather.temp.toString())
        binding.status.setText(currentWeather.status)
        binding.humidityValue.setText(currentWeather.humidity.toString() + Constant.DV_HUMIDITY)
        binding.windValue.setText(currentWeather.windSpeed.toString() + Constant.DV_SPEED)
        binding.visionValue.setText(currentWeather.vision.toString() + Constant.DV_VISION)
    }

    private fun clickDayItem(positon: Int) {
        //TODO implement later
    }

    private fun hourCurrentPosition(hourList: MutableList<Weather>): Int {
        for (i in 0 until hourList.size) {
            if (MyWeather.checkHourCurrent(hourList[i].date)) {
                return i
            }
        }
        return 0
    }

    override fun onClick(add: View?) {
        //TODO implement later
    }
}
