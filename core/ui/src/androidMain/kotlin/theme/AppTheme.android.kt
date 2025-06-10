package theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowInsetsControllerCompat

@Composable
internal actual fun SystemAppearance(isDark: Boolean) {
    (LocalView.current.context as? Activity)?.window?.let { window ->
        val pageBackground = MaterialTheme.colorScheme.background
        LaunchedEffect(isDark) {
            WindowInsetsControllerCompat(window, window.decorView).apply {
                isAppearanceLightStatusBars = isDark
                isAppearanceLightNavigationBars = isDark
            }

            // Set status bar color explicitly after enabling edge-to-edge
            window.statusBarColor = pageBackground.toArgb()
            window.navigationBarColor = pageBackground.toArgb()
        }
    }
}