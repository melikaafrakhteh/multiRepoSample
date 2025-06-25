package theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
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


private val LocalThemeIsDark = compositionLocalOf { mutableStateOf(false) }

@Composable
private fun ProvideTheme(
    isDarkState: MutableState<Boolean>,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalThemeIsDark provides isDarkState) {
        content()
    }
}

private val LocalAppDimens = staticCompositionLocalOf<Dimensions> {
    error("No AppDimens provided")
}

@Composable
private fun ProvideDimens(
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalAppDimens provides Dimensions()) {
        content()
    }
}

@Composable
fun AppTheme(
    systemIsDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val isDarkState = remember(systemIsDark) { mutableStateOf(systemIsDark) }
    ProvideTheme(isDarkState) {
        ProvideDimens {
            MaterialTheme(
                colorScheme = if (systemIsDark) DarkColorScheme else LightColorScheme,
                content = {
                    SystemAppearance(!isDarkState.value)

                    Surface(content = content)
                }
            )
        }
    }
}

val Dimens: Dimensions
    @Composable
    @ReadOnlyComposable
    get() = LocalAppDimens.current

@Composable
internal expect fun SystemAppearance(isDark: Boolean)
