package chistousov.ilya.current_weather.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import chistousov.ilya.current_weather.domain.GetCurrentWeatherUseCase
import chistousov.ilya.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
) : BaseViewModel() {

    fun getCurrentWeather() = viewModelScope.launch {
        val weather = getCurrentWeatherUseCase("Санкт-Петербург", "ru", "metric")
        weather.collectLatest {
            Log.d("CurrentWeatherViewModel", it.toString())
        }
    }
}