package nl.jaysh.spoorweg.core.network.dto.station

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.jaysh.spoorweg.core.model.station.Station
import nl.jaysh.spoorweg.core.model.station.StationType
import nl.jaysh.spoorweg.core.utils.valueOfOrNull

@Serializable
data class StationDTO(
    @SerialName("id") val id: StationIdentificationDTO,
    @SerialName("names") val names: StationNamesDTO,
    @SerialName("tracks") val tracks: List<String>,
    @SerialName("stationType") val stationType: String,
)

fun StationDTO.toStation(): Station = Station(
    uicCode = id.uicCode,
    name = names.long,
    tracks = tracks,
    stationType = valueOfOrNull<StationType>(stationType) ?: StationType.UNKNOWN,
)
