package com.ngadt.weatherapp.screen.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ngadt.weatherapp.data.model.Weather
import com.ngadt.weatherapp.databinding.DayItemBinding
import com.ngadt.weatherapp.utils.Constant
import com.ngadt.weatherapp.utils.MyWeather

class DayAdapter(
    private val clickInterface: (Int) -> Unit
) : RecyclerView.Adapter<DayAdapter.ViewHolder>() {

    private var listDay = mutableListOf<Weather>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DayItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(listDay[position])
    }

    override fun getItemCount(): Int {
        return listDay.size
    }

    fun setDataToList(list: MutableList<Weather>) {
        listDay.clear()
        listDay.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val itemBinding: DayItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindView(weather: Weather) {
            itemBinding.apply {
                txtDate.setText(MyWeather.formatDay(weather.date))
                txtDay.setText(MyWeather.formatDateDay(weather.date))
                val iconUrl = Constant.BASE_URL_IMAGE + weather.icon + Constant.DV_IMG
                Glide.with(itemBinding.root).load(iconUrl).into(iconSun)
                txtStatus.setText(weather.status)
                humidity.setText(weather.humidity.toString() + Constant.DV_HUMIDITY)
                minTemp.setText(weather.tempMin.toString())
                maxTemp.setText(weather.tempMax.toString())
                dayItem.setOnClickListener {
                    clickInterface(adapterPosition)
                }
            }
        }
    }
}
