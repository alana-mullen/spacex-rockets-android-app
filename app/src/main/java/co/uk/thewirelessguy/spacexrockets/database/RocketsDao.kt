package co.uk.thewirelessguy.spacexrockets.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.uk.thewirelessguy.spacexrockets.model.database.RocketsEntity

@Dao
interface RocketsDao {

    @Query("SELECT * FROM rockets")
    fun getRockets(): LiveData<List<RocketsEntity>>

    @Query("SELECT * FROM rockets WHERE active")
    fun getActiveRockets(): LiveData<List<RocketsEntity>>

    @Query("SELECT * FROM rockets WHERE id LIKE :rocketId")
    fun getRocketById(rocketId: Int): RocketsEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(rockets: List<RocketsEntity>)
}