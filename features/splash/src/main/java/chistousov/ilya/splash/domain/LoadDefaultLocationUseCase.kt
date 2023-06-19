package chistousov.ilya.splash.domain

import chistousov.ilya.splash.domain.repository.SplashRepository
import javax.inject.Inject

class LoadDefaultLocationUseCase @Inject constructor(private val repository: SplashRepository) {

    suspend operator fun invoke() = repository.loadDefaultLocation()
}