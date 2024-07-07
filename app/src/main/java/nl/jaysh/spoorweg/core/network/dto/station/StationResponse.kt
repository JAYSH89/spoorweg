package nl.jaysh.spoorweg.core.network.dto.station

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.jaysh.spoorweg.core.extension.valueOfOrNull
import nl.jaysh.spoorweg.core.model.station.Station
import nl.jaysh.spoorweg.core.model.station.StationType

@Serializable
data class StationResponse(
    @SerialName("payload") val payload: List<StationDTO>,
) {
    fun toStation(): List<Station> = payload.map { dto ->
        Station(
            uicCode = dto.id.uicCode,
            name = dto.names.long,
            tracks = dto.tracks,
            stationType = valueOfOrNull<StationType>(dto.stationType) ?: StationType.UNKNOWN,
        )
    }
}
