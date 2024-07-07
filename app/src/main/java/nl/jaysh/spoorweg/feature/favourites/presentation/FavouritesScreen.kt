package nl.jaysh.spoorweg.feature.favourites.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import nl.jaysh.spoorweg.core.ui.theme.SpoorwegTheme

@Preview
@Composable
private fun FavouritesScreenPreview() = SpoorwegTheme {
    FavouritesScreenContent(state = FavouritesState())
}

@Composable
fun FavouritesScreen(viewModel: FavouritesViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    FavouritesScreenContent(state = state)
}

@Composable
private fun FavouritesScreenContent(state: FavouritesState) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Favourites")
    }
}