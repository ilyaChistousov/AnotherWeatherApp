package chistousov.ilya.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import chistousov.ilya.data.room.entity.LatestDataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LatestDataDao {

    @Query("SELECT * FROM latest_data")
    fun getLatestData(): Flow<LatestDataEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLatestData(latestDataEntity: LatestDataEntity)
}