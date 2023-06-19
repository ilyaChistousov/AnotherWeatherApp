package chistousov.ilya.splash.presentation

import android.Manifest
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import chistousov.ilya.presentation.BaseViewModel
import chistousov.ilya.splash.domain.LoadCurrentLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val loadCurrentLocationUseCase: LoadCurrentLocationUseCase,
    private val loadDefaultLocationUseCase: LoadCurrentLocationUseCase,
    private val splashScreenRouter: SplashScreenRouter
) : BaseViewModel() {

    fun loadCurrentLocation(latitude: Double, longitude: Double) = viewModelScope.launch {
        Log.d("SplashScreenViewModel", "loadCurrentLocation $latitude $longitude")
        delay(10000000)
        splashScreenRouter.launchCurrentWeather()
    }

    fun loadDefaultLocation() {
        Log.d("SplashScreenViewModel", "loadDefaultLocation")
    }
}