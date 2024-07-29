package nl.jaysh.spoorweg.feature.favourites.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(FavouritesState())
    val state: StateFlow<FavouritesState> = _state
}

data class FavouritesState(
    val isLoading: Boolean = false,
)
