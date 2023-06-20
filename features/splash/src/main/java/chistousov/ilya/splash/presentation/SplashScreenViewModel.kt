package chistousov.ilya.splash.presentation

import androidx.lifecycle.viewModelScope
import chistousov.ilya.common.Result
import chistousov.ilya.presentation.BaseViewModel
import chistousov.ilya.splash.R
import chistousov.ilya.splash.domain.LoadDefaultLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val loadDefaultLocationUseCase: LoadDefaultLocationUseCase,
    private val splashScreenRouter: SplashScreenRouter
) : BaseViewModel() {

    val loadingState = flowValue<Result<Boolean>>(Result.Loading)

    init {
        loadDefaultLocation()
    }

    private fun loadDefaultLocation() = viewModelScope.launch {
        delay(500)
        loadingState.value = loadDefaultLocationUseCase()
    }

    fun launchCurrentWeather(isSuccess: Boolean) {
        if (!isSuccess) showToast(resource.getString(R.string.missing_connection))
        viewModelScope.launch {
            delay(500)
            splashScreenRouter.launchCurrentWeather(isSuccess)
        }
    }
}