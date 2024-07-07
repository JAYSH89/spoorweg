package nl.jaysh.spoorweg.core.network.dto.station

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StationDTO(
    @SerialName("id") val id: StationIdentificationDTO,
    @SerialName("names") val names: StationNamesDTO,
    @SerialName("tracks") val tracks: List<String>,
    @SerialName("stationType") val stationType: String,
)
