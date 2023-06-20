package chistousov.ilya.forecast.presentation

import androidx.lifecycle.viewModelScope
import chistousov.ilya.common.Result
import chistousov.ilya.forecast.domain.GetForecastUseCase
import chistousov.ilya.forecast.domain.entity.Forecast
import chistousov.ilya.forecast.domain.entity.ForecastItem
import chistousov.ilya.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val getForecastUseCase: GetForecastUseCase
) : BaseViewModel() {

    val forecastItem = flowValue<Result<Forecast>>(Result.Loading)

    init {
        loadForecast()
    }
    private fun loadForecast() = viewModelScope.launch {
        forecastItem.value = getForecastUseCase()
    }
}