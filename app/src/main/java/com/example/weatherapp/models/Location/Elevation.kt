package com.example.weatherapp.models.Location


import com.google.gson.annotations.SerializedName

data class Elevation(
    @SerializedName("Imperial")
    val imperial: Imperial?,
    @SerializedName("Metric")
    val metric: Metric?
)