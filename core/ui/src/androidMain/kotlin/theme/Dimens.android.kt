package theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
actual fun getScreenSizeInfo(): ScreenSizeInfo {
    val density = LocalDensity.current
    val config = LocalConfiguration.current
    val heightDp = config.screenHeightDp.dp
    val widthDp = config.screenWidthDp.dp

    return ScreenSizeInfo(
        heightPX = with(density) { heightDp.roundToPx() },
        widthPX = with(density) { widthDp.roundToPx() },
        heightDP = heightDp,
        widthDP = widthDp
    )
}