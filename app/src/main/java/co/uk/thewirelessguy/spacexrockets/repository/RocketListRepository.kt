package co.uk.thewirelessguy.spacexrockets.repository

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import co.uk.thewirelessguy.spacexrockets.database.RocketsDao
import co.uk.thewirelessguy.spacexrockets.model.Rockets
import co.uk.thewirelessguy.spacexrockets.model.asDatabaseModel
import co.uk.thewirelessguy.spacexrockets.model.database.asDomainModel
import co.uk.thewirelessguy.spacexrockets.network.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject


class RocketListRepository @Inject constructor(
    private val client: ApiInterface,
    private val rocketsDao: RocketsDao,
    private val sharedPreferences: SharedPreferences
) {

    var filterActiveRockets = sharedPreferences.getBoolean("filter_active_rockets", false)

    val rockets: LiveData<List<Rockets>> = Transformations.map(
        when {
            // Filter rockets
            // Todo: fix LiveData update
            filterActiveRockets -> {
                Timber.d("rocketsDao.getActiveRockets()")
                rocketsDao.getActiveRockets()
            }
            else -> {
                Timber.d("rocketsDao.getRockets()")
                rocketsDao.getRockets()
            }
        }
    ) {
        it.asDomainModel()
    }

    /**
     * Refresh the data stored in the offline cache.
     */
    suspend fun fetchRocketList() {
        withContext(Dispatchers.IO) {
            Timber.d("refresh rockets");
            val rockets = client.getRockets(2, 0)
            rocketsDao.insertAll(rockets.asDatabaseModel())
        }
    }

}
