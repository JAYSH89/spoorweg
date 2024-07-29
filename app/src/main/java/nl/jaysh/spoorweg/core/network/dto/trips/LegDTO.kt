package nl.jaysh.spoorweg.core.network.dto.trips

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.jaysh.spoorweg.core.model.trips.Leg

@Serializable
data class LegDTO(
    @SerialName("direction") val direction: String? = null,
    @SerialName("stops") val stops: List<StopDTO>,
    @SerialName("cancelled") val cancelled: Boolean,
)

fun LegDTO.toLeg(): Leg = Leg(
    direction = direction,
    stops = stops.map { it.toStop() },
    cancelled = cancelled,
)
