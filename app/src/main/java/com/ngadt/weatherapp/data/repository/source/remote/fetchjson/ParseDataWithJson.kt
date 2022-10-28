package com.ngadt.weatherapp.data.repository.source.remote.fetchjson

import com.ngadt.weatherapp.data.model.WeatherEntry
import notNull
import org.json.JSONException
import org.json.JSONObject

class ParseDataWithJson {
    fun parseJsonToData(jsonObject: JSONObject?, keyEntity: String): Any {
        val data = mutableListOf<Any>()
        try {
            when (keyEntity) {
                WeatherEntry.WEATHERS -> {
                    val item = parseJsonToObject(jsonObject, keyEntity)
                    item.notNull {
                        data.add(it)
                    }
                }
                WeatherEntry.HOUR, WeatherEntry.DAYS -> {
                    val jsonArray = jsonObject?.getJSONArray(WeatherEntry.DAYS)
                    for (i in 0 until (jsonArray?.length() ?: 0)) {
                        val item = parseJsonToObject(jsonArray?.getJSONObject(i), keyEntity)
                        item.notNull {
                            data.add(it)
                        }
                    }
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return data
    }

    private fun parseJsonToObject(jsonObject: JSONObject?, keyEntity: String): Any? {
        try {
            jsonObject?.notNull {
                return when (keyEntity) {
                    WeatherEntry.WEATHERS -> ParseJson().weatherParseJson(it)
                    WeatherEntry.DAYS -> ParseJson().dayParseJson(it)
                    WeatherEntry.HOUR -> ParseJson().hourParseJson(it)
                    else -> null
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return null
    }
}
