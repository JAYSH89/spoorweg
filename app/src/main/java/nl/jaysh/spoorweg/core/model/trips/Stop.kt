package nl.jaysh.spoorweg.core.model.trips

import kotlinx.serialization.Serializable
import java.time.OffsetDateTime

data class Stop(
    val uicCode: String? = null,
    val name: String? = null,
    val plannedDepartureDateTime: OffsetDateTime? = null,
    val plannedDepartureTimeZoneOffset: Int? = null,
    val actualDepartureDateTime: OffsetDateTime? = null,
    val actualDepartureTimeZoneOffset: Int? = null,
    val plannedArrivalDateTime: OffsetDateTime? = null,
    val plannedArrivalTimeZoneOffset: Int? = null,
    val actualArrivalDateTime: OffsetDateTime? = null,
    val actualArrivalTimeZoneOffset: Int? = null,
    val actualDepartureTrack: String? = null,
    val plannedDepartureTrack: String? = null,
    val plannedArrivalTrack: String? = null,
    val actualArrivalTrack: String? = null,
    val arrivalDelayInSeconds: Int? = null,
    val cancelled: Boolean,
)
