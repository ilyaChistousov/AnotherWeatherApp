package chistousov.ilya.current_weather.presentation

import androidx.lifecycle.viewModelScope
import chistousov.ilya.common.Result
import chistousov.ilya.current_weather.domain.GetDefaultWeatherUseCase
import chistousov.ilya.current_weather.domain.entity.CurrentWeather
import chistousov.ilya.presentation.BaseViewModel
import dagger.assisted.AssistedFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetDefaultWeatherUseCase,
    private val currentWeatherRouter: CurrentWeatherRouter
) : BaseViewModel() {

    val currentWeatherState = flowValue<Result<CurrentWeather>>(Result.Loading)

    init {
        loadCurrentWeather()
    }

    private fun loadCurrentWeather() = viewModelScope.launch {
        currentWeatherState.value = getCurrentWeatherUseCase()
    }

    fun launchWeatherDetails() {
        currentWeatherRouter.launchWeatherDetails()
    }

    fun launchForecast() {
        currentWeatherRouter.launchForecast()
    }
}