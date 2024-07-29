package nl.jaysh.spoorweg.core.network.dto.trips

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.jaysh.spoorweg.core.model.trips.Stop
import nl.jaysh.spoorweg.core.utils.OffsetDateTimeSerializer
import java.time.OffsetDateTime

@Serializable
data class StopDTO(
    @SerialName("uicCode")
    val uicCode: String? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("plannedDepartureDateTime")
    @Serializable(with = OffsetDateTimeSerializer::class)
    val plannedDepartureDateTime: OffsetDateTime? = null,

    @SerialName("plannedDepartureTimeZoneOffset")
    val plannedDepartureTimeZoneOffset: Int? = null,

    @SerialName("actualDepartureDateTime")
    @Serializable(with = OffsetDateTimeSerializer::class)
    val actualDepartureDateTime: OffsetDateTime? = null,

    @SerialName("actualDepartureTimeZoneOffset")
    val actualDepartureTimeZoneOffset: Int? = null,

    @SerialName("plannedArrivalDateTime")
    @Serializable(with = OffsetDateTimeSerializer::class)
    val plannedArrivalDateTime: OffsetDateTime? = null,

    @SerialName("plannedArrivalTimeZoneOffset")
    val plannedArrivalTimeZoneOffset: Int? = null,

    @SerialName("actualArrivalDateTime")
    @Serializable(with = OffsetDateTimeSerializer::class)
    val actualArrivalDateTime: OffsetDateTime? = null,

    @SerialName("actualArrivalTimeZoneOffset")
    val actualArrivalTimeZoneOffset: Int? = null,

    @SerialName("actualDepartureTrack")
    val actualDepartureTrack: String? = null,

    @SerialName("plannedDepartureTrack")
    val plannedDepartureTrack: String? = null,

    @SerialName("plannedArrivalTrack")
    val plannedArrivalTrack: String? = null,

    @SerialName("actualArrivalTrack")
    val actualArrivalTrack: String? = null,

    @SerialName("arrivalDelayInSeconds")
    val arrivalDelayInSeconds: Int? = null,

    @SerialName("cancelled")
    val cancelled: Boolean,
)

fun StopDTO.toStop(): Stop = Stop(
    uicCode = uicCode,
    name = name,
    plannedDepartureDateTime = plannedDepartureDateTime,
    plannedDepartureTimeZoneOffset = plannedDepartureTimeZoneOffset,
    actualDepartureDateTime = actualDepartureDateTime,
    actualDepartureTimeZoneOffset = actualDepartureTimeZoneOffset,
    plannedArrivalDateTime = plannedArrivalDateTime,
    plannedArrivalTimeZoneOffset = plannedArrivalTimeZoneOffset,
    actualArrivalDateTime = actualArrivalDateTime,
    actualArrivalTimeZoneOffset = actualArrivalTimeZoneOffset,
    actualDepartureTrack = actualDepartureTrack,
    plannedDepartureTrack = plannedDepartureTrack,
    plannedArrivalTrack = plannedArrivalTrack,
    actualArrivalTrack = actualArrivalTrack,
    arrivalDelayInSeconds = arrivalDelayInSeconds,
    cancelled = cancelled,
)
