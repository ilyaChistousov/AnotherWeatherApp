package chistousov.ilya.current_weather.presentation

import androidx.lifecycle.viewModelScope
import chistousov.ilya.common.MissingInternetException
import chistousov.ilya.common.Result
import chistousov.ilya.current_weather.domain.GetDefaultWeatherUseCase
import chistousov.ilya.current_weather.domain.entity.CurrentWeather
import chistousov.ilya.presentation.BaseViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class CurrentWeatherViewModel @AssistedInject constructor(
    @Assisted private val screen: CurrentWeatherFragment.Screen,
    private val getDefaultWeatherUseCase: GetDefaultWeatherUseCase,
    private val currentWeatherRouter: CurrentWeatherRouter
) : BaseViewModel() {

    val currentWeatherState = flowValue<Result<CurrentWeather>>(Result.Loading)

    init {
        load()
    }

    private fun load() = viewModelScope.launch {
        if (screen.isSuccessLoading) {
            currentWeatherState.value = getDefaultWeatherUseCase()
        } else {
            currentWeatherState.value = Result.Error(MissingInternetException())
        }
    }

    fun launchWeatherDetails() {
        currentWeatherRouter.launchWeatherDetails()
    }

    fun launchForecast() {
        currentWeatherRouter.launchForecast()
    }

    @AssistedFactory
    interface Factory {
        fun create(screen: CurrentWeatherFragment.Screen): CurrentWeatherViewModel
    }
}