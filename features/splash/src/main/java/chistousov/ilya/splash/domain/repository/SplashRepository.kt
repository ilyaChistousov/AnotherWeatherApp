package chistousov.ilya.splash.domain.repository

interface SplashRepository {

    suspend fun loadCurrentLocation(): Boolean
    suspend fun loadDefaultLocation(): Boolean
}