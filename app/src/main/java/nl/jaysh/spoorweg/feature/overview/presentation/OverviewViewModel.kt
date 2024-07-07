package nl.jaysh.spoorweg.feature.overview.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class OverviewViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(OverviewState())
    val state: StateFlow<OverviewState> = _state
}

data class OverviewState(
    val isLoading: Boolean = false,
)