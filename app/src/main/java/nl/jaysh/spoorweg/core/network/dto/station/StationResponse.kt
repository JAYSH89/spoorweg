package nl.jaysh.spoorweg.core.network.dto.station

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StationResponse(
    @SerialName("payload") val payload: List<StationDTO>,
)
