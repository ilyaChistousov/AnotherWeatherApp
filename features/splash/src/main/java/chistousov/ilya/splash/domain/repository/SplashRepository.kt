package chistousov.ilya.splash.domain.repository

interface SplashRepository {
    suspend fun loadCurrentLocation(latitude: Double, longitude: Double): Boolean
    suspend fun loadDefaultLocation(): Boolean
}