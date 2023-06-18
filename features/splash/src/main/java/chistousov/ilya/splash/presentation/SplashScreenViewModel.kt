package chistousov.ilya.splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import chistousov.ilya.splash.domain.LoadCurrentLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class SplashScreenViewModel(
    private val loadCurrentLocationUseCase: LoadCurrentLocationUseCase
) : ViewModel() {

    fun loadCurrentLocation() = viewModelScope.launch {
        loadCurrentLocationUseCase()
        delay(2000)
    }
}