package theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlinx.browser.window

@Composable
actual fun getScreenSizeInfo(): ScreenSizeInfo {
    val density = LocalDensity.current

    val hPX = window.innerHeight
    val wPX = window.innerWidth

    return remember {
        ScreenSizeInfo(
            heightPX = hPX,
            widthPX = wPX,
            heightDP = hPX.dp,
            widthDP = wPX.dp
        )
    }
}