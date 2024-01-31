package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.network.Api
import com.example.weatherapp.network.HeaderInterceptor
import com.example.weatherapp.repositories.WeatherRepoImpl
import com.example.weatherapp.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(module {
                single {
                    val client = OkHttpClient.Builder().addInterceptor(HeaderInterceptor()).build()
                    Retrofit.Builder()
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL)
                        .build()
                }
                single {
                    val retrofit: Retrofit = get()
                    retrofit.create(Api::class.java)
                }
                single {
                    val api: Api = get()
                    WeatherRepoImpl(api)
                } bind WeatherRepoImpl::class
            })
        }


    }
}