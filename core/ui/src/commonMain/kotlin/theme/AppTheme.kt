package theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF00BFEE),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFFFF9A0D),
    onSecondary = Color(0xFFFFFFFF),
    error = Color(0xFFEE504F),
    background = Color(0xFF232324),
    surface = Color(0xFF2B2B2B),
    outline = Color(0xFF404040),
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF00BFEE),
    onPrimary = Color(0xFFeef2ff),
    secondary = Color(0xffFFC05F),
    onSecondary = Color(0xffFFF4E1),
    error = Color(0xffF44336),
    background = Color(0xffFEFEFE),
    surface = Color(0xffFCFCFC),
    outline = Color(0xffEEEEEE),
)


val LocalThemeIsDark = compositionLocalOf { mutableStateOf(false) }

@Composable
fun AppTheme(
    systemIsDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val isDarkState = remember(systemIsDark) { mutableStateOf(systemIsDark) }
    CompositionLocalProvider(
        LocalThemeIsDark provides isDarkState,
    ) {
        MaterialTheme(
            colorScheme = if (systemIsDark) DarkColorScheme else LightColorScheme,
            content = {
                SystemAppearance(!isDarkState.value)

                Surface(content = content)
            }
        )
    }
}

@Composable
internal expect fun SystemAppearance(isDark: Boolean)
