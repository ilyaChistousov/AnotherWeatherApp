package chistousov.ilya.splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import chistousov.ilya.splash.domain.LoadCurrentLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val splashScreenRouter: SplashScreenRouter
) : ViewModel() {

    fun loadCurrentLocation() = viewModelScope.launch {
        delay(2000)
        splashScreenRouter.launchCurrentWeather()
    }
}