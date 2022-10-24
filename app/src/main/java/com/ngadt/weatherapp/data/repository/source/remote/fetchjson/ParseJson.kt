package com.ngadt.weatherapp.data.repository.source.remote.fetchjson

import com.ngadt.weatherapp.data.model.Weather
import com.ngadt.weatherapp.data.model.WeatherEntry
import org.json.JSONObject

class ParseJson {

    fun weatherParseJson(jsonObject: JSONObject): Weather {
        jsonObject.let {
            val date = it.getInt(WeatherEntry.DATE)
            val mainObject = it.getJSONObject(WeatherEntry.MAIN)
            val temp = mainObject.getInt(WeatherEntry.TEMP)
            val humidity = mainObject.getInt(WeatherEntry.HUMIDITY)
            val vision = it.getInt(WeatherEntry.VISION)
            val windObject = it.getJSONObject(WeatherEntry.WIND)
            val windSpeed = windObject.getDouble(WeatherEntry.SPEED).toFloat()
            val cloudObject = it.getJSONObject(WeatherEntry.CLOUD)
            val cloud = cloudObject.getInt(WeatherEntry.ALL)
            val jsonArray = it.getJSONArray(WeatherEntry.WEATHERS)
            val weatherObject = jsonArray.getJSONObject(0)
            val status = weatherObject.getString(WeatherEntry.STATUS)
            val description = weatherObject.getString(WeatherEntry.DESCRIPTION)
            val icon = weatherObject.getString(WeatherEntry.ICON)
            return Weather(date,temp,humidity,vision,windSpeed,cloud,status,description,icon)
        }

    }
}
