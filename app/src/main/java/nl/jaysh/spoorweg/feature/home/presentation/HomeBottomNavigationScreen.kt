package nl.jaysh.spoorweg.feature.home.presentation

import androidx.annotation.DrawableRes
import nl.jaysh.spoorweg.R
import nl.jaysh.spoorweg.core.ui.navigation.Destination

sealed class HomeBottomNavigationScreen(
    val route: String,
    val title: String,
    @DrawableRes val icon: Int,
) {
    data object Overview: HomeBottomNavigationScreen(
        route = Destination.OVERVIEW,
        title = "Overview",
        icon = R.drawable.map,
    )

    data object Favourites: HomeBottomNavigationScreen(
        route = Destination.FAVOURITES,
        title = "Favourites",
        icon = R.drawable.star,
    )

    data object Settings: HomeBottomNavigationScreen(
        route = Destination.SETTINGS,
        title = "Settings",
        icon = R.drawable.cogwheel,
    )
}
