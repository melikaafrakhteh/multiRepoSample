package theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class Dimensions() {
    val spaceSmall: Dp = 4.dp
    val spaceMedium: Dp = 7.dp
    val spaceNormal: Dp = 10.dp
    val spaceLarge: Dp = 14.dp

}

/** Getting screen size info for UI-related calculations */
data class ScreenSizeInfo(val heightPX: Int, val widthPX: Int, val heightDP: Dp, val widthDP: Dp)

@Composable
expect fun getScreenSizeInfo(): ScreenSizeInfo