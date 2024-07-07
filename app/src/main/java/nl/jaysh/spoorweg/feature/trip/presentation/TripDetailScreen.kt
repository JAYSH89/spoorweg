package nl.jaysh.spoorweg.feature.trip.presentation

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
fun TripDetailScreenPreview() = SpoorwegTheme {
    TripDetailScreenContent(state = TripDetailState())
}

@Composable
fun TripDetailScreen(viewModel: TripDetailViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    TripDetailScreenContent(state = state)
}

@Composable
private fun TripDetailScreenContent(state: TripDetailState) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Trip detail")
    }
}