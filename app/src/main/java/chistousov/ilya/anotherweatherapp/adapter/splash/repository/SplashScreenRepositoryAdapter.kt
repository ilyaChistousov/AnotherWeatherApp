package chistousov.ilya.anotherweatherapp.adapter.splash.repository

import chistousov.ilya.data.splash_screen.DataSplashScreenRepository
import chistousov.ilya.splash.domain.repository.SplashRepository
import javax.inject.Inject

class SplashScreenRepositoryAdapter @Inject constructor(
    private val dataSplashScreenRepository: DataSplashScreenRepository
) : SplashRepository {

    override suspend fun loadDefaultLocation(): Boolean {
        return dataSplashScreenRepository.loadDefaultLocation()
    }
}