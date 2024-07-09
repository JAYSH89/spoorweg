package nl.jaysh.spoorweg.feature.overview.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import nl.jaysh.spoorweg.core.data.RailwayRepository
import nl.jaysh.spoorweg.core.di.coroutines.IoDispatcher
import nl.jaysh.spoorweg.core.model.station.Station
import java.time.Instant
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.ZoneId
import javax.inject.Inject

@HiltViewModel
class OverviewViewModel @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val railwayRepository: RailwayRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(OverviewState())
    val state: StateFlow<OverviewState> = _state

    private var debounce: Job? = null

    fun onEvent(event: OverviewEvent) {
        when (event) {
            is OverviewEvent.DestinationValueChanged -> {
                _state.update { it.copy(destination = event.destination) }
                search(event.destination)
            }

            is OverviewEvent.DepartureValueChanged -> {
                _state.update { it.copy(departure = event.departure) }
                search(event.departure)
            }

            is OverviewEvent.DatePickerValueChanged -> updateDate(
                selectedMillis = event.selectedMillis,
            )

            is OverviewEvent.TimePickerValueChanged -> updateTime(
                hour = event.hour,
                minute = event.minute
            )

            is OverviewEvent.ResetDateTimePicker -> _state.update {
                it.copy(selectedDate = event.date ?: OffsetDateTime.now())
            }
        }
    }

    private fun search(query: String) {
        debounce?.cancel()
        debounce = viewModelScope.launch(dispatcher) {
            delay(timeMillis = 300)
            _state.update { it.copy(isLoading = true) }

            val stationSuggestions = railwayRepository.getStation(query = query)
            _state.update { it.copy(isLoading = false, stationSuggestions = stationSuggestions) }
        }
    }

    private fun updateTime(hour: Int, minute: Int) {
        val newTime = LocalTime.of(hour, minute)

        val updatedDate = state.value.selectedDate.with(newTime)
        _state.update { it.copy(selectedDate = updatedDate) }
    }

    private fun updateDate(selectedMillis: Long) {
        val newDate = Instant.ofEpochMilli(selectedMillis)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()

        val updatedDate = state.value.selectedDate.with(newDate)
        _state.update { it.copy(selectedDate = updatedDate) }
    }
}

sealed interface OverviewEvent {
    data class DepartureValueChanged(val departure: String) : OverviewEvent
    data class DestinationValueChanged(val destination: String) : OverviewEvent
    data class DatePickerValueChanged(val selectedMillis: Long) : OverviewEvent
    data class TimePickerValueChanged(val hour: Int, val minute: Int) : OverviewEvent
    data class ResetDateTimePicker(val date: OffsetDateTime? = null) : OverviewEvent
}

data class OverviewState(
    val isLoading: Boolean = false,
    val departure: String = "",
    val destination: String = "",
    val stationSuggestions: List<Station> = emptyList(),
    val selectedDate: OffsetDateTime = OffsetDateTime.now(),
)