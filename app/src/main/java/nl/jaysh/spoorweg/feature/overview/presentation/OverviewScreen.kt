package nl.jaysh.spoorweg.feature.overview.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import nl.jaysh.spoorweg.core.ui.components.textfield.SpoorwegTextField
import nl.jaysh.spoorweg.core.ui.theme.SpoorwegIcons
import nl.jaysh.spoorweg.core.ui.theme.SpoorwegTheme
import nl.jaysh.spoorweg.core.ui.theme.crayolaYellow
import nl.jaysh.spoorweg.core.ui.theme.peachBlossom

@Preview(showBackground = true)
@Composable
fun OverviewScreenPreview(modifier: Modifier = Modifier) = SpoorwegTheme {
    OverviewScreenContent(state = OverviewState(), onEvent = {})
}

@Composable
fun OverviewScreen(viewModel: OverviewViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    OverviewScreenContent(state = state, onEvent = viewModel::onEvent)
}

@Composable
private fun OverviewScreenContent(
    state: OverviewState,
    onEvent: (OverviewEvent) -> Unit,
) {
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
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        Text(
            text = "Plan your journey",
            style = MaterialTheme.typography.headlineLarge,
        )
        TripInput(
            departureValue = state.departure,
            destinationValue = state.destination,
            onEvent = onEvent,
        )
    }
}

@Composable
private fun TripInput(
    modifier: Modifier = Modifier,
    departureValue: String,
    destinationValue: String,
    onEvent: (OverviewEvent) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(28.dp))
            .background(MaterialTheme.colorScheme.inverseSurface)
            .padding(all = 24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        DepartureTextField(value = departureValue, onEvent = onEvent)

        DestinationTextField(value = destinationValue, onEvent = onEvent)

        SearchButton { onEvent(OverviewEvent.SearchButtonPressed) }
    }
}

@Composable
private fun DepartureTextField(
    modifier: Modifier = Modifier,
    value: String,
    onEvent: (OverviewEvent) -> Unit,
) {
    SpoorwegTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        placeholder = "Departure",
        leadingIcon = SpoorwegIcons().tracking,
        trailingIcon = SpoorwegIcons().close,
        onValueChange = { onEvent(OverviewEvent.DepartureValueChanged(departure = it)) },
        onClickTrailingIcon = {},
    )
}

@Composable
private fun DestinationTextField(
    modifier: Modifier = Modifier,
    value: String,
    onEvent: (OverviewEvent) -> Unit,
) {
    SpoorwegTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        placeholder = "Destination",
        leadingIcon = SpoorwegIcons().locationPin,
        trailingIcon = SpoorwegIcons().switch,
        onValueChange = { onEvent(OverviewEvent.DestinationValueChanged(destination = it)) },
        onClickTrailingIcon = {},
    )
}

@Composable
private fun SearchButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    TextButton(
        modifier = modifier.fillMaxWidth(),
        content = {
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = "Plan your trip",
                color = MaterialTheme.colorScheme.inverseOnSurface,
            )
        },
        onClick = onClick,
    )
}
