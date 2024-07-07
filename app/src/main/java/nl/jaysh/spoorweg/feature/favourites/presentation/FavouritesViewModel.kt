package nl.jaysh.spoorweg.feature.favourites.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class FavouritesViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(FavouritesState())
    val state: StateFlow<FavouritesState> = _state
}

data class FavouritesState(
    val isLoading: Boolean = false,
)
