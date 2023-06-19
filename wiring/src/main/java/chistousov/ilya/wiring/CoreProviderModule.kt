package chistousov.ilya.wiring

import android.content.Context
import chistousov.ilya.common.Core
import chistousov.ilya.common.CoreProvider
import chistousov.ilya.common.Permissions
import chistousov.ilya.common_impl.ActivityRequired
import chistousov.ilya.common_impl.DefaultCoreProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ElementsIntoSet

@Module
@InstallIn(SingletonComponent::class)
class CoreProviderModule {

    @Provides
    fun provideCoreProvider(
        @ApplicationContext appContext: Context
    ): CoreProvider {
        return DefaultCoreProvider(appContext)
    }

    @Provides
    @ElementsIntoSet
    fun provideActivityRequired(
        permissions: Permissions
    ) : Set<ActivityRequired> {
        val set = mutableSetOf<ActivityRequired>()

        if (permissions is ActivityRequired) set.add(permissions)

        return set
    }

    @Provides
    fun providePermissions() : Permissions {
        return Core.permissions
    }
}
