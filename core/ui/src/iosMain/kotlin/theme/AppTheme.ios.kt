package theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import extensions.toUIColor
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.zeroValue
import platform.CoreGraphics.CGRect
import platform.UIKit.UIApplication
import platform.UIKit.UIColor
import platform.UIKit.UINavigationBar
import platform.UIKit.UIView
import platform.UIKit.UIWindow
import platform.UIKit.statusBarManager
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue

@Composable
internal actual fun SystemAppearance(isDark: Boolean) {
    val color = MaterialTheme.colorScheme.background
    val statusBar = statusBarView()

    SideEffect {
        dispatch_async(dispatch_get_main_queue()) {
            statusBar.backgroundColor = color.toUIColor()
            UINavigationBar.appearance().backgroundColor = color.toUIColor()
            setSafeAreaBackgroundColor(color)
            UIApplication.sharedApplication.keyWindow?.rootViewController?.view?.backgroundColor =
                color.toUIColor()
        }
    }
}


@OptIn(ExperimentalForeignApi::class)
@Composable
private fun statusBarView() = remember {
    val keyWindow: UIWindow? =
        UIApplication.sharedApplication.windows.firstOrNull { (it as? UIWindow)?.isKeyWindow() == true } as? UIWindow
    val tag = 3848245L

    keyWindow?.backgroundColor = UIColor.redColor

    keyWindow?.viewWithTag(tag) ?: run {
        val frame =
            keyWindow?.windowScene?.statusBarManager?.statusBarFrame ?: zeroValue<CGRect>()

        val statusBarView = UIView(frame = frame)
        statusBarView.tag = tag
        statusBarView.layer.zPosition = 999999.0

        keyWindow?.addSubview(statusBarView)
        statusBarView
    }
}


// Function to set the safe area background color (the area between the status bar and app content)
private fun setSafeAreaBackgroundColor(color: Color) {
    val keyWindow = UIApplication.sharedApplication.windows.firstOrNull() as? UIWindow
    val rootViewController = keyWindow?.rootViewController

    // Make sure we modify the root view's background color
    rootViewController?.view?.apply {
        // Access safe area layout guide and set background color
        this.backgroundColor = color.toUIColor()

        // You can also ensure that the view respects the safe area,
        // and it won't override the safe area insets
        this.layoutIfNeeded()
    }
}