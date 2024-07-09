package nl.jaysh.spoorweg.feature.overview.presentation

import app.cash.turbine.test
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import nl.jaysh.spoorweg.core.data.RailwayRepository
import org.junit.Before
import org.junit.Test
import java.time.Instant
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.ZoneId
import kotlin.test.assertEquals

class OverviewViewModelTest {

    @MockK
    lateinit var railwayRepository: RailwayRepository

    private lateinit var viewModel: OverviewViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = OverviewViewModel(railwayRepository = railwayRepository)
    }

    @Test
    fun `test DestinationValueChanged event`() = runTest {
        val destination = "Amsterdam"

        viewModel.state.test {
            viewModel.onEvent(OverviewEvent.DestinationValueChanged(destination = destination))

            assertEquals("", awaitItem().destination)
            assertEquals("Amsterdam", awaitItem().destination)
        }
    }

    @Test
    fun `test DepartureValueChanged event`() = runTest {
        val departure = "Rotterdam"

        viewModel.state.test {
            viewModel.onEvent(OverviewEvent.DepartureValueChanged(departure = departure))

            assertEquals(expected = "", actual = awaitItem().departure)
            assertEquals(expected = "Rotterdam", actual = awaitItem().departure)
        }
    }

    @Test
    fun `test DatePickerValueChanged event`() = runTest {
        val millis = 1_622_505_600_000L // 01/06/2021

        viewModel.state.test {
            viewModel.onEvent(OverviewEvent.DatePickerValueChanged(millis))

            val newDate = Instant.ofEpochMilli(millis)
                .atZone(ZoneId.systemDefault())
                .toLocalDate()

            awaitItem()
            assertEquals(expected = newDate, actual = awaitItem().selectedDate.toLocalDate())
        }
    }

    @Test
    fun `test TimePickerValueChanged event`() = runTest {
        val hour = 10
        val minute = 30

        viewModel.state.test {
            viewModel.onEvent(OverviewEvent.TimePickerValueChanged(hour = hour, minute = minute))

            val newDate = LocalTime.of(hour, minute)

            awaitItem()
            assertEquals(expected = newDate, actual = awaitItem().selectedDate.toLocalTime())
        }
    }

    @Test
    fun `test ResetDateTimePicker event`() = runTest {
        val date = OffsetDateTime.now()

        viewModel.state.test {
            viewModel.onEvent(OverviewEvent.ResetDateTimePicker(date = date))

            awaitItem()
            assertEquals(expected = date, actual = awaitItem().selectedDate)
        }
    }

    @Test
    fun `test SearchButtonPressed event`() = runTest {
        viewModel.state.test {
            viewModel.onEvent(OverviewEvent.SearchButtonPressed)
            // TODO
        }
    }
}
