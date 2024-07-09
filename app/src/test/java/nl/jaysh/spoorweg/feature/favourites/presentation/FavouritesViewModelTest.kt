package nl.jaysh.spoorweg.feature.favourites.presentation

import io.mockk.MockKAnnotations
import org.junit.Before

class FavouritesViewModelTest {

    private lateinit var viewModel: FavouritesViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = FavouritesViewModel()
    }
}