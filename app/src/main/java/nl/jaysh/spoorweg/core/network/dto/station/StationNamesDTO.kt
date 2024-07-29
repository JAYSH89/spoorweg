package nl.jaysh.spoorweg.core.network.dto.station

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StationNamesDTO(
    @SerialName("long") val long: String,
    @SerialName("medium") val medium: String,
    @SerialName("short") val short: String,
    @SerialName("synonyms") val synonyms: List<String>,
)
