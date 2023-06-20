package chistousov.ilya.data.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import chistousov.ilya.data.room.dao.ForecastDao
import chistousov.ilya.data.room.dao.LatestDataDao
import chistousov.ilya.data.room.entity.ForecastEntity
import chistousov.ilya.data.room.entity.LatestDataEntity
import chistousov.ilya.data.room.entity.TimeIntervalListConverter

@Database(entities = [LatestDataEntity::class, ForecastEntity::class], version = 1)
@TypeConverters(TimeIntervalListConverter::class)
abstract class LatestDataDb : RoomDatabase() {

    abstract fun latestDataDao(): LatestDataDao

    abstract fun forecastDao(): ForecastDao
}