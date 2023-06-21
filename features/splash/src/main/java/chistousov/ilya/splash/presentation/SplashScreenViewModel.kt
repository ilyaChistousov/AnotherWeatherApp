package chistousov.ilya.splash.presentation

import androidx.lifecycle.viewModelScope
import chistousov.ilya.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val splashScreenRouter: SplashScreenRouter
) : BaseViewModel() {

    fun launchCurrentWeather() = viewModelScope.launch {
        delay(1000)
        splashScreenRouter.launchCurrentWeather()
    }
}