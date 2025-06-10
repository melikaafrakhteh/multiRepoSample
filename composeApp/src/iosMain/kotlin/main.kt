import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeUIViewController
import com.app.faraBank.appContent.BackPressHandler
import com.app.faraBank.appContent.MultiRepoSampleApp
import platform.UIKit.UIViewController

@OptIn(ExperimentalComposeUiApi::class)
fun MainViewController(): UIViewController = ComposeUIViewController(
    configure = { enforceStrictPlistSanityCheck = false }
) {
    MultiRepoSampleApp(backPressHandler = BackPressHandler())
}