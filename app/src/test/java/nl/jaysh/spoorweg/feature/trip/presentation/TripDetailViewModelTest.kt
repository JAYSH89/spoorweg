package nl.jaysh.spoorweg.feature.trip.presentation

import io.mockk.MockKAnnotations
import org.junit.Before

class TripDetailViewModelTest {

    private lateinit var viewModel: TripDetailViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = TripDetailViewModel()
    }
}