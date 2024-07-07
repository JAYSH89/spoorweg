package nl.jaysh.spoorweg.feature.home.presentation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun HomeBottomNavigation(navController: NavHostController) {
    val screens = remember {
        listOf(
            HomeBottomNavigationScreen.Overview,
            HomeBottomNavigationScreen.Favourites,
            HomeBottomNavigationScreen.Settings,
        )
    }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val tabBarDestination = screens.any { it.route == currentDestination?.route }

    if (tabBarDestination) {
        NavigationBar {
            screens.forEach { screen ->
                BottomNavigationItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController,
                )
            }
        }
    }
}

@Composable
private fun RowScope.BottomNavigationItem(
    screen: HomeBottomNavigationScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    NavigationBarItem(
        selected = selected,
        label = {
            BottomNavigationLabel(text = screen.title)
        },
        icon = {
            Icon(painter = painterResource(id = screen.icon), contentDescription = screen.title)
        },
        onClick = {
            if (!selected) navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
    )
}

@Composable
private fun BottomNavigationLabel(text: String) = Text(
    text = text,
)
