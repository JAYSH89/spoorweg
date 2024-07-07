package nl.jaysh.spoorweg.feature.trip.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TripDetailViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(TripDetailState())
    val state: StateFlow<TripDetailState> = _state
}

data class TripDetailState(
    val isLoading: Boolean = false,
)