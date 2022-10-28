package com.ngadt.weatherapp.data.repository.source.remote.fetchjson

import com.ngadt.weatherapp.data.model.Weather
import com.ngadt.weatherapp.data.model.WeatherEntry
import org.json.JSONObject

class ParseJson {

    fun weatherParseJson(jsonObject: JSONObject): Weather {
        jsonObject.let {
            val date = it.getLong(WeatherEntry.DATE)
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
            val location = it.getString(WeatherEntry.LOCATION)
            return Weather(
                date, temp, humidity, vision, windSpeed, cloud, status, description, icon, location
            )
        }
    }

    fun dayParseJson(jsonObject: JSONObject): Weather {
        jsonObject.let {
            val date = it.getLong(WeatherEntry.DATE)
            val tempObject = it.getJSONObject(WeatherEntry.TEMP)
            val temp = tempObject.getInt(WeatherEntry.DAY)
            val tempMin = tempObject.getInt(WeatherEntry.MIN)
            val tempMax = tempObject.getInt(WeatherEntry.MAX)
            val tempMorn = tempObject.getInt(WeatherEntry.MORN)
            val tempNight = tempObject.getInt(WeatherEntry.NIGHT)
            val humidity = it.getInt(WeatherEntry.HUMIDITY)
            val windSpeed = it.getDouble(WeatherEntry.SPEED).toFloat()
            val cloud = it.getInt(WeatherEntry.CLOUD)
            val jsonArray = it.getJSONArray(WeatherEntry.WEATHERS)
            val weatherObject = jsonArray.getJSONObject(0)
            val status = weatherObject.getString(WeatherEntry.STATUS)
            val description = weatherObject.getString(WeatherEntry.DESCRIPTION)
            val icon = weatherObject.getString(WeatherEntry.ICON)
            val sunset = it.getInt(WeatherEntry.SUNSET)
            val sunrise = it.getInt(WeatherEntry.SUNRISE)
            val pressure = it.getInt(WeatherEntry.PRESSURE)
            return Weather(date = date, temp = temp, humidity = humidity, windSpeed = windSpeed, cloud = cloud,
                status = status, description = description, icon = icon, tempMax = tempMax, tempMin = tempMin,
                tempMorn = tempMorn, tempNight = tempNight, sunrise = sunrise, sunset = sunset, pressure = pressure
            )
        }
    }

    fun hourParseJson(jsonObject: JSONObject): Weather {
        jsonObject.let {
            val date = it.getLong(WeatherEntry.DATE)
            val weatherArray = it.getJSONArray(WeatherEntry.WEATHERS)
            val weatherObject = weatherArray.getJSONObject(0)
            val icon = weatherObject.getString(WeatherEntry.ICON)
            val mainObject = it.getJSONObject(WeatherEntry.MAIN)
            val temp = mainObject.getInt(WeatherEntry.TEMP)
            return Weather(date = date, icon = icon, temp = temp)
        }
    }
}
