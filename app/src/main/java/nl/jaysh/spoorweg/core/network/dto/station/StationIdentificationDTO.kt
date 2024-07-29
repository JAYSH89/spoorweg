package nl.jaysh.spoorweg.core.network.dto.station

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StationIdentificationDTO(
    @SerialName("uicCode") val uicCode: String,
    @SerialName("evaCode") val evaCode: String,
    @SerialName("cdCode") val cdCode: Int,
    @SerialName("code") val code: String,
)
