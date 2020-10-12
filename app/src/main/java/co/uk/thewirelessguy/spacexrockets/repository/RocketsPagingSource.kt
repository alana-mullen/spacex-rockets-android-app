package co.uk.thewirelessguy.spacexrockets.repository

import android.content.SharedPreferences
import androidx.paging.PagingSource
import androidx.paging.RemoteMediator
import co.uk.thewirelessguy.spacexrockets.database.RocketsDao
import co.uk.thewirelessguy.spacexrockets.model.database.RocketsEntity
import co.uk.thewirelessguy.spacexrockets.network.ApiInterface
import javax.inject.Inject

/*
class RocketsPagingSource @Inject constructor(
    private val client: ApiInterface,
    private val rocketsDao: RocketsDao,
    private val sharedPreferences: SharedPreferences
) : PagingSource<String, RocketsEntity>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, RocketsEntity> {
        return
    }

}*/
