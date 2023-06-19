package chistousov.ilya.data.room.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import chistousov.ilya.data.room.LatestDataDb
import chistousov.ilya.data.room.dao.LatestDataDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext appContext: Context
    ): LatestDataDb {
        return Room.databaseBuilder(
            appContext,
            LatestDataDb::class.java,
            "latest_data"
        ).build()
    }

    @Provides
    @Singleton
    fun provideLatestDataDao(database: LatestDataDb) : LatestDataDao {
        return database.latestDataDao()
    }
}