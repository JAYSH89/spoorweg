package nl.jaysh.spoorweg.feature.overview.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Preview
@Composable
fun OverviewScreenPreview(modifier: Modifier = Modifier) {
    OverviewScreenContent(state = OverviewState())
}

@Composable
fun OverviewScreen(viewModel: OverviewViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    OverviewScreenContent(state = state)
}

@Composable
private fun OverviewScreenContent(state: OverviewState) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Overview")

        TextField(
            value = "",
            placeholder = {
                Text("Text")
            },
            onValueChange = {},
        )
    }
}
