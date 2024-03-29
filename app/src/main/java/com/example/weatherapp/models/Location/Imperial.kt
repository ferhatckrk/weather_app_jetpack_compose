package com.example.weatherapp.models.Location


import com.google.gson.annotations.SerializedName

data class Imperial(
    @SerializedName("Unit")
    val unit: String?,
    @SerializedName("UnitType")
    val unitType: Int?,
    @SerializedName("Value")
    val value: Double?
)