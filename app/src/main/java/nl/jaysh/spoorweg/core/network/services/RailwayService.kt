package nl.jaysh.spoorweg.core.network.services

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import nl.jaysh.spoorweg.core.network.dto.station.StationDTO
import nl.jaysh.spoorweg.core.network.dto.station.StationResponse
import nl.jaysh.spoorweg.core.network.dto.trips.TripDTO
import nl.jaysh.spoorweg.core.network.dto.trips.TripResponse
import java.time.OffsetDateTime
import javax.inject.Inject

class RailwayService @Inject constructor(private val httpClient: HttpClient) {
    suspend fun getStation(query: String): List<StationDTO> {
        val response = httpClient.get(urlString = "nsapp-stations/v3") {
            parameter("q", query)
        }

        // TODO: ERROR HANDLING
        val body = response.body<StationResponse>()
        return body.payload
    }

    suspend fun getTrip(
        fromStation: String,
        toStation: String,
        dateTime: OffsetDateTime,
        searchForArrival: Boolean,
    ): List<TripDTO> {
        val response = httpClient.get(urlString = "/reisinformatie-api/api/v3/trips") {
            parameter("fromStation", fromStation)
            parameter("toStation", toStation)
            parameter("dateTime", dateTime.toString())
            parameter("searchForArrive", searchForArrival)
        }

        // TODO: ERROR HANDLING
        val body = response.body<TripResponse>()
        return body.trips
    }
}