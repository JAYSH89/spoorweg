package nl.jaysh.spoorweg.feature.trip.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import nl.jaysh.spoorweg.core.ui.theme.SpoorwegTheme
import nl.jaysh.spoorweg.core.ui.theme.crayolaYellow
import nl.jaysh.spoorweg.core.ui.theme.peachBlossom

@Preview(showBackground = true)
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.0f to crayolaYellow,
                        0.75f to peachBlossom,
                    ),
                ),
            )
            .padding(all = 24.dp),
    ) {
        Text(
            text = "Trip detail",
            style = MaterialTheme.typography.displayLarge,
        )
    }
}