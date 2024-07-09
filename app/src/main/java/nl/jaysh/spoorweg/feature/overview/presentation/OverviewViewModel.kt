package nl.jaysh.spoorweg.feature.overview.presentation

import androidx.compose.ui.geometry.Offset
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import nl.jaysh.spoorweg.core.data.RailwayRepository
import java.time.Instant
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.ZoneId
import javax.inject.Inject

@HiltViewModel
class OverviewViewModel @Inject constructor(
    private val railwayRepository: RailwayRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(OverviewState())
    val state: StateFlow<OverviewState> = _state

    fun onEvent(event: OverviewEvent) {
        when (event) {
            is OverviewEvent.DestinationValueChanged -> _state.update {
                it.copy(destination = event.destination)
            }

            is OverviewEvent.DepartureValueChanged -> _state.update {
                it.copy(departure = event.departure)
            }

            OverviewEvent.SearchButtonPressed -> search()
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

    private fun search() {

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
    data object SearchButtonPressed : OverviewEvent
}

data class OverviewState(
    val isLoading: Boolean = false,
    val departure: String = "",
    val destination: String = "",
    val selectedDate: OffsetDateTime = OffsetDateTime.now(),
)