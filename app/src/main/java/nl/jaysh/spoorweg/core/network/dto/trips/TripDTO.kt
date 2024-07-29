package nl.jaysh.spoorweg.core.network.dto.trips

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.jaysh.spoorweg.core.model.trips.Trip

@Serializable
data class TripDTO(
    @SerialName("uid") val uid: String,
    @SerialName("legs") val legs: List<LegDTO>,
)

fun TripDTO.toTrip(): Trip = Trip(
    uid = uid,
    legs = legs.map { it.toLeg() },
)
