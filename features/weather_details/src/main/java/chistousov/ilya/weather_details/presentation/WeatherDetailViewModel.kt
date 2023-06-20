package chistousov.ilya.weather_details.presentation

import androidx.lifecycle.viewModelScope
import chistousov.ilya.common.Result
import chistousov.ilya.presentation.BaseScreenArgs
import chistousov.ilya.presentation.BaseViewModel
import chistousov.ilya.weather_details.domain.GetWeatherDetailsUseCase
import chistousov.ilya.weather_details.domain.entity.WeatherDetails
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherDetailViewModel @Inject constructor(
    private val getWeatherDetailsUseCase: GetWeatherDetailsUseCase
) : BaseViewModel() {

    val weatherDetails = flowValue<Result<WeatherDetails>>(Result.Loading)

    init {
       getWeatherDetails()
    }

    private fun getWeatherDetails() = viewModelScope.launch {
        weatherDetails.value = getWeatherDetailsUseCase()
    }
}