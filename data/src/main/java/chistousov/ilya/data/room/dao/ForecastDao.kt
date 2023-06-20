package chistousov.ilya.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import chistousov.ilya.data.room.entity.ForecastEntity

@Dao
interface ForecastDao {

    @Query("SELECT * FROM forecast")
    suspend fun getForecast(): ForecastEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForecast(forecastEntity: ForecastEntity)
}