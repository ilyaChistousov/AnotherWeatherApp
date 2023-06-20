package chistousov.ilya.splash.domain

import chistousov.ilya.common.MissingInternetException
import chistousov.ilya.common.Result
import chistousov.ilya.splash.domain.repository.SplashRepository
import javax.inject.Inject

class LoadDefaultLocationUseCase @Inject constructor(private val repository: SplashRepository) {

    suspend operator fun invoke(): Result<Boolean> {
        return try{
            Result.Success(repository.loadDefaultLocation())
        } catch (e: MissingInternetException) {
            Result.Error(e)
        }
    }
}