package chistousov.ilya.navigation.presentation.navigation

import androidx.annotation.IdRes
import androidx.annotation.NavigationRes

interface DestinationProvider {

    @NavigationRes
    fun provideNavigationGraphId(): Int

    @IdRes
    fun provideStartDestinationId(): Int
}
