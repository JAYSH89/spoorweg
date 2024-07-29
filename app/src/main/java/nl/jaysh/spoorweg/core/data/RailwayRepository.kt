package nl.jaysh.spoorweg.core.data

import nl.jaysh.spoorweg.core.model.station.Station
import nl.jaysh.spoorweg.core.model.trips.Trip
import nl.jaysh.spoorweg.core.network.dto.station.toStation
import nl.jaysh.spoorweg.core.network.dto.trips.toTrip
import nl.jaysh.spoorweg.core.network.services.RailwayService
import java.time.OffsetDateTime
import javax.inject.Inject

class RailwayRepository @Inject constructor(private val railwayService: RailwayService) {
    suspend fun getStation(query: String): List<Station> = railwayService
        .getStation(query = query)
        .map { dto -> dto.toStation() }

    suspend fun getTrip(
        fromStation: String,
        toStation: String,
        dateTime: OffsetDateTime,
        searchForArrival: Boolean,
    ): List<Trip> = railwayService
        .getTrip(
            fromStation = fromStation,
            toStation = toStation,
            dateTime = dateTime,
            searchForArrival = searchForArrival,
        ).map { dto -> dto.toTrip() }
}