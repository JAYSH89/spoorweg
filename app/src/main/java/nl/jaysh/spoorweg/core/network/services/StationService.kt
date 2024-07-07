package nl.jaysh.spoorweg.core.network.services

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import nl.jaysh.spoorweg.core.network.dto.station.StationDTO
import nl.jaysh.spoorweg.core.network.dto.station.StationResponse
import javax.inject.Inject

class StationService @Inject constructor(private val httpClient: HttpClient) {
    suspend fun getStations(query: String): List<StationDTO> {
        val response = httpClient.get(urlString = "nsapp-stations/v3") {
            parameter("q", query)
        }

        val body = response.body<StationResponse>()
        return body.payload
    }
}