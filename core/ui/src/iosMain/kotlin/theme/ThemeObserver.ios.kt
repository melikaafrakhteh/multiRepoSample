package theme

import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSOperationQueue
import platform.UIKit.UIApplicationDidBecomeActiveNotification
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle
import platform.UIKit.UIViewController
import platform.darwin.NSObjectProtocol
import utils.Logger

actual class ThemeObserver : UIViewController("UIView", null) {

    private var isDarkMode = isDarkMode()
    private var onThemeChanged: ((Boolean) -> Unit)? = null
    private var themeChangeObserver: NSObjectProtocol? = null

    actual fun startObservingThemeChanges(onThemeChanged: (Boolean) -> Unit) {
        this.onThemeChanged = onThemeChanged

        // Remove the existing observer if present
        themeChangeObserver?.let { NSNotificationCenter.defaultCenter.removeObserver(it) }

        // Observe theme changes
        themeChangeObserver = NSNotificationCenter.defaultCenter.addObserverForName(
            name = UIApplicationDidBecomeActiveNotification,
            `object` = null,
            queue = NSOperationQueue.mainQueue
        ) { _ ->
            Logger.info("NSNotificationCenter > OnDeviceThemeChanged(isDark): ${isDarkMode()}")
            if (isDarkMode() != isDarkMode) {
                isDarkMode = !isDarkMode
                onThemeChanged.invoke(isDarkMode)
            }
        }
    }

    private fun isDarkMode(): Boolean {
        val isDarkMode =
            UIScreen.mainScreen.traitCollection.userInterfaceStyle == UIUserInterfaceStyle.UIUserInterfaceStyleDark
        return isDarkMode
    }
}