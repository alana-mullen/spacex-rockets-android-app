package co.uk.thewirelessguy.spacexrockets.network

import co.uk.thewirelessguy.spacexrockets.model.network.RocketsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("rockets")
    suspend fun getRockets(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): List<RocketsResponse>

}