package nl.jaysh.spoorweg.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import nl.jaysh.spoorweg.feature.favourites.presentation.FavouritesScreen
import nl.jaysh.spoorweg.feature.overview.presentation.OverviewScreen
import nl.jaysh.spoorweg.feature.settings.presentation.SettingsScreen

@Composable
fun HomeNavHost(rootNavController: NavController, homeNavController: NavHostController) {
    NavHost(navController = homeNavController, startDestination = Destination.OVERVIEW) {
        composable(Destination.OVERVIEW) {
            OverviewScreen()
        }

        composable(Destination.FAVOURITES) {
            FavouritesScreen()
        }

        composable(Destination.SETTINGS) {
            SettingsScreen()
        }
    }
}