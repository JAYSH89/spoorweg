package nl.jaysh.spoorweg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import nl.jaysh.spoorweg.core.ui.navigation.RootNavHost
import nl.jaysh.spoorweg.core.ui.theme.SpoorwegTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()

            SpoorwegTheme {
                RootNavHost(navController = navController)
            }
        }
    }
}