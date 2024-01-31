package com.example.weatherapp.models.DailyForecast


import com.google.gson.annotations.SerializedName

data class Maximum(
    @SerializedName("Unit")
    val unit: String?,
    @SerializedName("UnitType")
    val unitType: Int?,
    @SerializedName("Value")
    val value: Int?
)