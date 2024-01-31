package com.example.weatherapp.repositories

import com.example.weatherapp.models.BaseModel
import com.example.weatherapp.models.DailyForecast.DailyForecast
import com.example.weatherapp.models.HourlyForecast.HourlyForecast
import com.example.weatherapp.models.Location.Location

interface WeatherRepo {

    suspend fun searchLocation(query: String): BaseModel<Location>
    suspend fun getDailyForecast(locationKey: String): BaseModel<DailyForecast>
    suspend fun getHourlyForecast(locationKey: String): BaseModel<HourlyForecast>


}