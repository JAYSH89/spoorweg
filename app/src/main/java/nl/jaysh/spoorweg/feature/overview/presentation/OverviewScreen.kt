package nl.jaysh.spoorweg.feature.overview.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import nl.jaysh.spoorweg.core.ui.components.picker.SpoorwegDatePicker
import nl.jaysh.spoorweg.core.ui.components.picker.SpoorwegTimePicker
import nl.jaysh.spoorweg.core.ui.components.textfield.SpoorwegTextField
import nl.jaysh.spoorweg.core.ui.theme.SpoorwegIcons
import nl.jaysh.spoorweg.core.ui.theme.SpoorwegTheme
import nl.jaysh.spoorweg.core.ui.theme.crayolaYellow
import nl.jaysh.spoorweg.core.ui.theme.peachBlossom
import java.time.format.DateTimeFormatter

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
            state = state,
            onEvent = onEvent,
        )
    }
}

@Composable
private fun TripInput(
    modifier: Modifier = Modifier,
    state: OverviewState,
    onEvent: (OverviewEvent) -> Unit,
) {
    val datePickerVisible = remember { mutableStateOf(false) }
    val timePickerVisible = remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(28.dp))
            .background(MaterialTheme.colorScheme.inverseSurface)
            .padding(all = 24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        DepartureTextField(
            value = state.departure,
            onEvent = onEvent,
            onClickTrailingIcon = {},
        )

        DestinationTextField(
            value = state.destination,
            onEvent = onEvent,
            onClickTrailingIcon = {},
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            DateTimeButton(
                onClick = { datePickerVisible.value = !datePickerVisible.value },
                text = state.selectedDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            )

            Spacer(modifier = Modifier.width(12.dp))

            DateTimeButton(
                onClick = { timePickerVisible.value = !timePickerVisible.value },
                text = state.selectedDate.format(DateTimeFormatter.ofPattern("HH:mm")),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = SpoorwegIcons().clock),
                        contentDescription = "clock",
                        tint = MaterialTheme.colorScheme.inverseOnSurface,
                    )
                }
            )

            Spacer(modifier = Modifier.width(12.dp))

            IconButton(onClick = { onEvent(OverviewEvent.ResetDateTimePicker()) }) {
                Icon(
                    painter = painterResource(id = SpoorwegIcons().history),
                    contentDescription = "now",
                    tint = MaterialTheme.colorScheme.inverseOnSurface,
                )
            }

            SpoorwegDatePicker(
                date = state.selectedDate.toLocalDate(),
                visible = datePickerVisible.value,
                onDismissRequest = { datePickerVisible.value = !datePickerVisible.value },
                onConfirm = { millis ->
                    val event = OverviewEvent.DatePickerValueChanged(selectedMillis = millis)
                    onEvent(event)

                    datePickerVisible.value = !datePickerVisible.value
                },
            )

            SpoorwegTimePicker(
                hour = state.selectedDate.hour,
                minute = state.selectedDate.minute,
                visible = timePickerVisible.value,
                onDismissRequest = { timePickerVisible.value = !timePickerVisible.value },
                onConfirm = { (hour, minute) ->
                    val event = OverviewEvent.TimePickerValueChanged(
                        hour = hour,
                        minute = minute,
                    )
                    onEvent(event)

                    timePickerVisible.value = !timePickerVisible.value
                }
            )
        }

        SearchButton { onEvent(OverviewEvent.SearchButtonPressed) }
    }
}

@Composable
private fun DepartureTextField(
    modifier: Modifier = Modifier,
    value: String,
    onEvent: (OverviewEvent) -> Unit,
    onClickTrailingIcon: () -> Unit,
) {
    SpoorwegTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        placeholder = "Departure",
        leadingIcon = SpoorwegIcons().tracking,
        trailingIcon = SpoorwegIcons().close,
        onValueChange = { onEvent(OverviewEvent.DepartureValueChanged(departure = it)) },
        onClickTrailingIcon = onClickTrailingIcon,
    )
}

@Composable
private fun DestinationTextField(
    modifier: Modifier = Modifier,
    value: String,
    onEvent: (OverviewEvent) -> Unit,
    onClickTrailingIcon: () -> Unit,
) {
    SpoorwegTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        placeholder = "Destination",
        leadingIcon = SpoorwegIcons().locationPin,
        trailingIcon = SpoorwegIcons().switch,
        onValueChange = { onEvent(OverviewEvent.DestinationValueChanged(destination = it)) },
        onClickTrailingIcon = onClickTrailingIcon,
    )
}

@Composable
private fun SearchButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    TextButton(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = "Plan your trip",
            color = MaterialTheme.colorScheme.inverseOnSurface,
        )
    }
}

@Composable
private fun DateTimeButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    trailingIcon: (@Composable () -> Unit)? = null,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonColors(
            containerColor = Color.Black,
            contentColor = MaterialTheme.colorScheme.inverseOnSurface,
            disabledContainerColor = MaterialTheme.colorScheme.inverseSurface,
            disabledContentColor = MaterialTheme.colorScheme.inverseOnSurface,
        ),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
        )

        if (trailingIcon != null) {
            Spacer(modifier = Modifier.width(8.dp))
            trailingIcon.invoke()
        }
    }
}
