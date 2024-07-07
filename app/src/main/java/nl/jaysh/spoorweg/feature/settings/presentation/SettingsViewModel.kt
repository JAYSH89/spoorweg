package nl.jaysh.spoorweg.feature.settings.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class SettingsViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(SettingsState())
    val state: StateFlow<SettingsState> = _state
}

data class SettingsState(
    val isLoading: Boolean = false,
)
