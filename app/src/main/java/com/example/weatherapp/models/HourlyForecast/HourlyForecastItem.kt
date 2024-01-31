package com.example.weatherapp.models.HourlyForecast


import com.google.gson.annotations.SerializedName

data class HourlyForecastItem(
    @SerializedName("DateTime")
    val dateTime: String?,
    @SerializedName("EpochDateTime")
    val epochDateTime: Int?,
    @SerializedName("HasPrecipitation")
    val hasPrecipitation: Boolean?,
    @SerializedName("IconPhrase")
    val iconPhrase: String?,
    @SerializedName("IsDaylight")
    val isDaylight: Boolean?,
    @SerializedName("Link")
    val link: String?,
    @SerializedName("MobileLink")
    val mobileLink: String?,
    @SerializedName("PrecipitationProbability")
    val precipitationProbability: Int?,
    @SerializedName("Temperature")
    val temperature: Temperature?,
    @SerializedName("WeatherIcon")
    val weatherIcon: Int?
)