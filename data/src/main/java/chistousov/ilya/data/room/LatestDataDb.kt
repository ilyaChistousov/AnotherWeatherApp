package chistousov.ilya.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import chistousov.ilya.data.room.dao.LatestDataDao
import chistousov.ilya.data.room.entity.LatestDataEntity

@Database(entities = [LatestDataEntity::class], version = 1)
abstract class LatestDataDb : RoomDatabase() {

    abstract fun latestDataDao(): LatestDataDao
}