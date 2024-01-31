package com.example.weatherapp.network

import com.example.weatherapp.models.DailyForecast.DailyForecast
import com.example.weatherapp.models.HourlyForecast.HourlyForecast
import com.example.weatherapp.models.Location.Location
import com.example.weatherapp.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("locations/v1/cities/search")
    suspend fun search(
        @Query("apikey") apikey: String = API_KEY,
        @Query("q") query: String
    ): Response<Location>


    @GET("forecasts/v1/daily/5day/{location_key}")
    suspend fun getDailyForecast(
        @Query("apikey") apikey: String = API_KEY,
        @Path("location_key") locationKey: String,
        @Query("metric") metric: Boolean = true
    ): Response<DailyForecast>


    @GET("forecasts/v1/hourly/12hour/{location_key}")
    suspend fun getHourlyForecast(
        @Query("apikey") apikey: String = API_KEY,
        @Path("location_key") locationKey: String,
        @Query("metric") metric: Boolean = true
    ): Response<HourlyForecast>


}