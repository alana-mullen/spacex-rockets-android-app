package co.uk.thewirelessguy.spacexrockets.model.network
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class RocketsResponse(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "active")
    val active: Boolean = false,
    @Json(name = "stages")
    val stages: Double? = null,
    @Json(name = "boosters")
    val boosters: Double? = null,
    @Json(name = "cost_per_launch")
    val costPerLaunch: Double? = null,
    @Json(name = "success_rate_pct")
    val successRatePct: Double? = null,
    @Json(name = "first_flight")
    val firstFlight: String = "",
    @Json(name = "country")
    val country: String = "",
    @Json(name = "company")
    val company: String? = null,
    @Json(name = "height")
    val height: Height? = null,
    @Json(name = "diameter")
    val diameter: Diameter? = null,
    @Json(name = "mass")
    val mass: Mass? = null,
    @Json(name = "payload_weights")
    val payloadWeights: List<PayloadWeight>? = null,
    @Json(name = "first_stage")
    val firstStage: FirstStage? = null,
    @Json(name = "second_stage")
    val secondStage: SecondStage? = null,
    @Json(name = "engines")
    val engines: Engines? = null,
    @Json(name = "landing_legs")
    val landingLegs: LandingLegs? = null,
    @Json(name = "flickr_images")
    val flickrImages: List<String>? = null,
    @Json(name = "wikipedia")
    val wikipedia: String = "",
    @Json(name = "description")
    val description: String = "",
    @Json(name = "rocket_id")
    val rocketId: String? = null,
    @Json(name = "rocket_name")
    val rocketName: String = "",
    @Json(name = "rocket_type")
    val rocketType: String? = null
)

@JsonClass(generateAdapter = true)
data class Height(
    @Json(name = "meters")
    val meters: Double? = null,
    @Json(name = "feet")
    val feet: Double? = null
)

@JsonClass(generateAdapter = true)
data class Diameter(
    @Json(name = "meters")
    val meters: Double? = null,
    @Json(name = "feet")
    val feet: Double? = null
)

@JsonClass(generateAdapter = true)
data class Mass(
    @Json(name = "kg")
    val kg: Double? = null,
    @Json(name = "lb")
    val lb: Double? = null
)

@JsonClass(generateAdapter = true)
data class PayloadWeight(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "kg")
    val kg: Double? = null,
    @Json(name = "lb")
    val lb: Double? = null
)

@JsonClass(generateAdapter = true)
data class FirstStage(
    @Json(name = "reusable")
    val reusable: Boolean? = null,
    @Json(name = "engines")
    val engines: Double? = null,
    @Json(name = "fuel_amount_tons")
    val fuelAmountTons: Double? = null,
    @Json(name = "burn_time_sec")
    val burnTimeSec: Any? = null,
    @Json(name = "thrust_sea_level")
    val thrustSeaLevel: ThrustSeaLevel? = null,
    @Json(name = "thrust_vacuum")
    val thrustVacuum: ThrustVacuum? = null
)

@JsonClass(generateAdapter = true)
data class SecondStage(
    @Json(name = "reusable")
    val reusable: Boolean? = null,
    @Json(name = "engines")
    val engines: Double? = null,
    @Json(name = "fuel_amount_tons")
    val fuelAmountTons: Double? = null,
    @Json(name = "burn_time_sec")
    val burnTimeSec: Any? = null,
    @Json(name = "thrust")
    val thrust: Thrust? = null,
    @Json(name = "payloads")
    val payloads: Payloads? = null
)

@JsonClass(generateAdapter = true)
data class Engines(
    @Json(name = "number")
    val number: Double? = null,
    @Json(name = "type")
    val type: String? = null,
    @Json(name = "version")
    val version: String? = null,
    @Json(name = "layout")
    val layout: Any? = null,
    @Json(name = "isp")
    val isp: Isp? = null,
    @Json(name = "engine_loss_max")
    val engineLossMax: Any? = null,
    @Json(name = "propellant_1")
    val propellant1: String? = null,
    @Json(name = "propellant_2")
    val propellant2: String? = null,
    @Json(name = "thrust_sea_level")
    val thrustSeaLevel: ThrustSeaLevelX? = null,
    @Json(name = "thrust_vacuum")
    val thrustVacuum: ThrustVacuumX? = null,
    @Json(name = "thrust_to_weight")
    val thrustToWeight: Double? = null
)

@JsonClass(generateAdapter = true)
data class LandingLegs(
    @Json(name = "number")
    val number: Double? = null,
    @Json(name = "material")
    val material: String? = null
)

@JsonClass(generateAdapter = true)
data class ThrustSeaLevel(
    @Json(name = "kN")
    val kN: Double? = null,
    @Json(name = "lbf")
    val lbf: Double? = null
)

@JsonClass(generateAdapter = true)
data class ThrustVacuum(
    @Json(name = "kN")
    val kN: Double? = null,
    @Json(name = "lbf")
    val lbf: Double? = null
)

@JsonClass(generateAdapter = true)
data class Thrust(
    @Json(name = "kN")
    val kN: Double? = null,
    @Json(name = "lbf")
    val lbf: Double? = null
)

@JsonClass(generateAdapter = true)
data class Payloads(
    @Json(name = "option_1")
    val option1: String? = null,
    @Json(name = "option_2")
    val option2: String? = null,
    @Json(name = "composite_fairing")
    val compositeFairing: CompositeFairing? = null
)

@JsonClass(generateAdapter = true)
data class CompositeFairing(
    @Json(name = "height")
    val height: HeightX? = null,
    @Json(name = "diameter")
    val diameter: DiameterX? = null
)

@JsonClass(generateAdapter = true)
data class HeightX(
    @Json(name = "meters")
    val meters: Any? = null,
    @Json(name = "feet")
    val feet: Any? = null
)

@JsonClass(generateAdapter = true)
data class DiameterX(
    @Json(name = "meters")
    val meters: Any? = null,
    @Json(name = "feet")
    val feet: Any? = null
)

@JsonClass(generateAdapter = true)
data class Isp(
    @Json(name = "sea_level")
    val seaLevel: Double? = null,
    @Json(name = "vacuum")
    val vacuum: Double? = null
)

@JsonClass(generateAdapter = true)
data class ThrustSeaLevelX(
    @Json(name = "kN")
    val kN: Double? = null,
    @Json(name = "lbf")
    val lbf: Double? = null
)

@JsonClass(generateAdapter = true)
data class ThrustVacuumX(
    @Json(name = "kN")
    val kN: Double? = null,
    @Json(name = "lbf")
    val lbf: Double? = null
)