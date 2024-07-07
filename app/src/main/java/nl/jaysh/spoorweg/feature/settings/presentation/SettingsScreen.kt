package nl.jaysh.spoorweg.feature.settings.presentation

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
private fun SettingsScreenPreview() = SpoorwegTheme {
    SettingsScreenContent(state = SettingsState())
}

@Composable
fun SettingsScreen(viewModel: SettingsViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    SettingsScreenContent(state = state)
}

@Composable
private fun SettingsScreenContent(state: SettingsState) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Settings")
    }
}
