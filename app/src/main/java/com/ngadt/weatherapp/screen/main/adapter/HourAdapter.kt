package com.ngadt.weatherapp.screen.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ngadt.weatherapp.data.model.Weather
import com.ngadt.weatherapp.databinding.DayItemBinding
import com.ngadt.weatherapp.databinding.HourItemBinding
import com.ngadt.weatherapp.utils.Constant
import com.ngadt.weatherapp.utils.MyWeather

class HourAdapter() : RecyclerView.Adapter<HourAdapter.ViewHolder>() {
    private var listHour = mutableListOf<Weather>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HourItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(listHour[position], position)
    }

    override fun getItemCount(): Int = listHour.size

    fun setDataToList(list: MutableList<Weather>) {
        listHour.clear()
        listHour.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val itemBinding: HourItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bindView(weather: Weather, position: Int) {
            itemBinding.apply {
                txtHour.setText(MyWeather.formatHour(weather.date, position))
                val iconUrl = Constant.BASE_URL_IMAGE + weather.icon + Constant.DV_IMG
                Glide.with(itemBinding.root).load(iconUrl).into(imgSun)
                txtTemp.setText(weather.temp.toString())
            }
        }
    }

}
