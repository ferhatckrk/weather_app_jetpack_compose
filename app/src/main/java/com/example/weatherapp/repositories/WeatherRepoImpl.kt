package com.example.weatherapp.repositories

import com.example.weatherapp.models.BaseModel
import com.example.weatherapp.models.DailyForecast.DailyForecast
import com.example.weatherapp.models.HourlyForecast.HourlyForecast
import com.example.weatherapp.models.Location.Location
import com.example.weatherapp.network.Api
import retrofit2.Response
import java.lang.Exception

class WeatherRepoImpl(private val api: Api) : WeatherRepo {
    override suspend fun searchLocation(query: String): BaseModel<Location> {
        return request {
            api.search(query = query)
        }
    }

    override suspend fun getDailyForecast(locationKey: String): BaseModel<DailyForecast> {
        return request {
            api.getDailyForecast(locationKey = locationKey)
        }
    }

    override suspend fun getHourlyForecast(locationKey: String): BaseModel<HourlyForecast> {
        return request {
            api.getHourlyForecast(locationKey = locationKey)
        }
    }
}

suspend fun <T> request(request: suspend () -> Response<T>): BaseModel<T> {
    try {
        request().also {
            return if (it.isSuccessful) {
                BaseModel.Success(it.body()!!)
            } else {
                BaseModel.Error(it.message().toString())
            }
        }
    } catch (e: Exception) {
        return BaseModel.Error(e.message.toString())
    }
}















