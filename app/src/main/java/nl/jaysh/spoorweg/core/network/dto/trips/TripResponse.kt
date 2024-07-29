package nl.jaysh.spoorweg.core.network.dto.trips

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TripResponse(
    @SerialName("trips") val trips: List<TripDTO>,
)