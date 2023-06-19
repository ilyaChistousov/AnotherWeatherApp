package chistousov.ilya.splash.domain

import chistousov.ilya.splash.domain.repository.SplashRepository
import javax.inject.Inject

class LoadCurrentLocationUseCase constructor(private val repository: SplashRepository) {

    suspend operator fun invoke() = repository.loadCurrentLocation()
}