package com.example.weatherapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.models.BaseModel
import com.example.weatherapp.models.Location.Location
import com.example.weatherapp.repositories.WeatherRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : ViewModel(), KoinComponent {

    val repo: WeatherRepo by inject()

    private val _location: MutableStateFlow<BaseModel<Location>?> = MutableStateFlow(null)
    val location = _location.asStateFlow()

    fun searchLocationText(query: String) {
        viewModelScope.launch {
            _location.update { BaseModel.Loading }
            repo.searchLocation(query = query).also { data ->
                _location.update{data}

            }

        }


    }