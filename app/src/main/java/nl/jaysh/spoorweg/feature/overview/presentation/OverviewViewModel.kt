package nl.jaysh.spoorweg.feature.overview.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class OverviewViewModel @Inject constructor() : ViewModel() {
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
        }
    }

    private fun search() {

    }
}

sealed interface OverviewEvent {
    data class DepartureValueChanged(val departure: String) : OverviewEvent
    data class DestinationValueChanged(val destination: String) : OverviewEvent
    data object SearchButtonPressed : OverviewEvent
}

data class OverviewState(
    val isLoading: Boolean = false,
    val departure: String = "",
    val destination: String = "",
)