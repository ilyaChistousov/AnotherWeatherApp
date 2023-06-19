package chistousov.ilya.splash.presentation

import androidx.lifecycle.viewModelScope
import chistousov.ilya.presentation.BaseViewModel
import chistousov.ilya.splash.domain.LoadDefaultLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val loadDefaultLocationUseCase: LoadDefaultLocationUseCase,
    private val splashScreenRouter: SplashScreenRouter
) : BaseViewModel() {

    val loadingState = flowValue(false)

    init {
        loadDefaultLocationUseCase
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