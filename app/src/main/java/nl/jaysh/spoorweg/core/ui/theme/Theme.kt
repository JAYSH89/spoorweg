package nl.jaysh.spoorweg.core.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = travelOrange,
    onPrimary = Color.Black,
    primaryContainer = travelOrange,
    onPrimaryContainer = Color.Black,
    inversePrimary = Color.Black,
    secondary = crayolaYellow,
    onSecondary = Color.Black,
    secondaryContainer = crayolaYellow,
    onSecondaryContainer = Color.Black,
    tertiary = nightPurple,
    onTertiary = Color.White,
    tertiaryContainer = nightPurple,
    onTertiaryContainer = Color.White,
    background = peachBlossom,
    onBackground = nightPurple,
    surface = peachBlossom,
    onSurface = Color.Black,
    surfaceVariant = crayolaYellow,
    onSurfaceVariant = Color.Black,
    surfaceTint = travelOrange,
    inverseSurface = peachBlossom,
    inverseOnSurface = nightPurple,
    error = danger,
    onError = Color.White,
    errorContainer = danger,
    onErrorContainer = Color.White,
    outline = nightPurple,
    outlineVariant = travelOrange,
    scrim = Purple80,
    surfaceBright = crayolaYellow,
    surfaceContainer = nightPurple,
    surfaceContainerHigh = travelOrange,
    surfaceContainerHighest = crayolaYellow,
    surfaceContainerLow = peachBlossom,
    surfaceContainerLowest = peachBlossom,
    surfaceDim = peachBlossom,
)

private val LightColorScheme = lightColorScheme(
    primary = travelOrange,
    onPrimary = Color.Black,
    primaryContainer = travelOrange,
    onPrimaryContainer = Color.Black,
    inversePrimary = Color.Black,
    secondary = crayolaYellow,
    onSecondary = Color.Black,
    secondaryContainer = crayolaYellow,
    onSecondaryContainer = Color.Black,
    tertiary = nightPurple,
    onTertiary = Color.White,
    tertiaryContainer = nightPurple,
    onTertiaryContainer = Color.White,
    background = peachBlossom,
    onBackground = nightPurple,
    surface = peachBlossom,
    onSurface = Color.Black,
    surfaceVariant = crayolaYellow,
    onSurfaceVariant = Color.Black,
    surfaceTint = travelOrange,
    inverseSurface = peachBlossom,
    inverseOnSurface = nightPurple,
    error = danger,
    onError = Color.White,
    errorContainer = danger,
    onErrorContainer = Color.White,
    outline = nightPurple,
    outlineVariant = travelOrange,
    scrim = Purple80,
    surfaceBright = crayolaYellow,
    surfaceContainer = nightPurple,
    surfaceContainerHigh = travelOrange,
    surfaceContainerHighest = crayolaYellow,
    surfaceContainerLow = peachBlossom,
    surfaceContainerLowest = peachBlossom,
    surfaceDim = peachBlossom,
)

@Composable
fun SpoorwegTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current

            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}