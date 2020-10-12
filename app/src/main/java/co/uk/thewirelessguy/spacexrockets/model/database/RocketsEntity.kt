package co.uk.thewirelessguy.spacexrockets.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import co.uk.thewirelessguy.spacexrockets.model.Rockets

/**
 * RocketsEntity represents a rocket entity in the database.
 */
@Entity(tableName = "rockets")
data class RocketsEntity(
    @PrimaryKey
    val id: Int,
    val active: Boolean,
    val rocketName: String,
    val firstFlight: String,
    val country: String,
    val image: String,
    val wikipedia: String,
    val description: String
)


/**
 * Map RocketsEntity to domain entities
 */
fun List<RocketsEntity>.asDomainModel(): List<Rockets> {
    return map {
        Rockets(
            id = it.id,
            active = it.active,
            rocketName = it.rocketName,
            firstFlight = it.firstFlight,
            country = it.country,
            image = it.image,
            wikipedia = it.wikipedia,
            description = it.description
        )
    }
}
