package com.example.weatherapp.models.DailyForecast


import com.google.gson.annotations.SerializedName

data class Day(
    @SerializedName("HasPrecipitation")
    val hasPrecipitation: Boolean?,
    @SerializedName("Icon")
    val icon: Int?,
    @SerializedName("IconPhrase")
    val iconPhrase: String?
)