package com.example.weatherapp.models.DailyForecast


import com.google.gson.annotations.SerializedName

data class DailyForecast(
    @SerializedName("DailyForecasts")
    val dailyForecasts: List<DailyForecastX>?,
    @SerializedName("Headline")
    val headline: Headline?
)