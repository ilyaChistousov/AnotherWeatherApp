package chistousov.ilya.navigation.presentation.navigation.di

import chistousov.ilya.common_impl.ActivityRequired
import chistousov.ilya.navigation.presentation.navigation.AppComponentRouter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
class AppComponentRouterModule {

    @Provides
    @IntoSet
    fun provideAppComponentRouterAsActivityRequired(
        appComponentRouter: AppComponentRouter
    ): ActivityRequired {
        return appComponentRouter
    }
}