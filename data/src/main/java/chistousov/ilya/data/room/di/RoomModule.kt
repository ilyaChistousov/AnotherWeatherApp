package chistousov.ilya.data.room.di

import android.content.Context
import androidx.room.Room
import chistousov.ilya.data.room.dao.ForecastDao
import chistousov.ilya.data.room.db.LatestDataDb
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
    fun provideLatestDataDao(database: LatestDataDb) : LatestDataDao {
        return database.latestDataDao()
    }

    @Provides
    fun provideForecastDao(database: LatestDataDb) : ForecastDao {
        return database.forecastDao()
    }
}