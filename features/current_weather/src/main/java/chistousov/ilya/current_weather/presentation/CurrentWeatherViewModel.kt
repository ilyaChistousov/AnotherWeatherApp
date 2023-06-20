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
    private val getDefaultWeatherUseCase: GetDefaultWeatherUseCase,
    private val currentWeatherRouter: CurrentWeatherRouter
) : BaseViewModel() {

    val currentWeatherState = flowValue<Result<CurrentWeather>>(Result.Loading)

    init {
        load()
    }

    fun load() = viewModelScope.launch {
        currentWeatherState.value = getDefaultWeatherUseCase()
    }

    fun launchWeatherDetails() {
        currentWeatherRouter.launchWeatherDetails()
    }

    fun launchForecast() {
        currentWeatherRouter.launchForecast()
    }
}