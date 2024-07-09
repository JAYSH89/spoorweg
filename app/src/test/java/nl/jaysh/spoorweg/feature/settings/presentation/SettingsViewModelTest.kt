package nl.jaysh.spoorweg.feature.settings.presentation

import io.mockk.MockKAnnotations
import nl.jaysh.spoorweg.feature.favourites.presentation.FavouritesViewModel
import org.junit.Before

class SettingsViewModelTest {

    private lateinit var viewModel: SettingsViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = SettingsViewModel()
    }
}