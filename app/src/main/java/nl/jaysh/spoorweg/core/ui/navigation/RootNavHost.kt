package nl.jaysh.spoorweg.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import nl.jaysh.spoorweg.feature.home.presentation.HomeScreen
import nl.jaysh.spoorweg.feature.trip.presentation.TripDetailScreen

@Composable
fun RootNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destination.HOME) {
        composable(Destination.HOME) {
            HomeScreen(rootNavController = navController)
        }

        composable(Destination.TRIP_DETAIL) {
            TripDetailScreen()
        }
    }
}