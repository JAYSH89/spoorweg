package nl.jaysh.spoorweg.feature.home.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import nl.jaysh.spoorweg.core.ui.navigation.HomeNavHost

@Composable
fun HomeScreen(
    rootNavController: NavController,
    homeNavController: NavHostController = rememberNavController(),
) {
    Scaffold(
        bottomBar = {
            HomeBottomNavigation(navController = homeNavController)
        },
    ) { contentPadding ->
        BackHandler { }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            content = {
                HomeNavHost(
                    rootNavController = rootNavController,
                    homeNavController = homeNavController,
                )
            }
        )
    }
}