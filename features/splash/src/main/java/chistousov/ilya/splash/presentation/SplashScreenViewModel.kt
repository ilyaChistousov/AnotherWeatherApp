package chistousov.ilya.splash.presentation

import androidx.lifecycle.viewModelScope
import chistousov.ilya.presentation.BaseViewModel
import chistousov.ilya.splash.domain.LoadCurrentLocationUseCase
import chistousov.ilya.splash.domain.LoadDefaultLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val loadCurrentLocationUseCase: LoadCurrentLocationUseCase,
    private val loadDefaultLocationUseCase: LoadDefaultLocationUseCase,
    private val splashScreenRouter: SplashScreenRouter
) : BaseViewModel() {

    val loadingState = flowValue(false)

    fun loadCurrentLocation(latitude: Double, longitude: Double) = viewModelScope.launch {
        if (loadCurrentLocationUseCase(latitude, longitude)) {
            loadingState.value = true
        }
        launchCurrentWeather()
    }

    fun loadDefaultLocation() = viewModelScope.launch {
        if (loadDefaultLocationUseCase()) {
            loadingState.value = true
        }
        launchCurrentWeather()
    }

    private fun launchCurrentWeather() {
        if (loadingState.value) {
            splashScreenRouter.launchCurrentWeather()
        }
    }
}