package chistousov.ilya.current_weather.presentation

import androidx.lifecycle.viewModelScope
import chistousov.ilya.common.Result
import chistousov.ilya.current_weather.domain.GetCurrentWeatherUseCase
import chistousov.ilya.current_weather.domain.GetDefaultWeatherUseCase
import chistousov.ilya.current_weather.domain.entity.CurrentWeather
import chistousov.ilya.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val getDefaultWeatherUseCase: GetDefaultWeatherUseCase
) : BaseViewModel() {

    private val state = MutableStateFlow(CurrentWeather("", 0, 0))
    val currentWeatherState = flowValue(CurrentWeather("", 0, 0))
    init {
        load()
    }

    fun load() = viewModelScope.launch {
        getDefaultWeatherUseCase().collect {
        }
    }

    fun getCurrentWeather() = viewModelScope.launch {
    }
}