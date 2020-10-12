package co.uk.thewirelessguy.spacexrockets.model

import co.uk.thewirelessguy.spacexrockets.model.database.RocketsEntity
import co.uk.thewirelessguy.spacexrockets.model.network.RocketsResponse

/**
 * Convert Network results to database objects
 */
fun List<RocketsResponse>.asDatabaseModel(): List<RocketsEntity> {
    return this.map {
        RocketsEntity(
            id = it.id,
            active = it.active,
            rocketName = it.rocketName,
            firstFlight = it.firstFlight,
            country = it.country,
            image = it.flickrImages?.get(0) ?: "",
            wikipedia = it.wikipedia,
            description = it.description
        )
    }
}