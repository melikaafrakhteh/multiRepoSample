import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeViewport
import com.sky.faraBank.appContent.app.App
import com.sky.faraBank.appContent.utils.BackPressHandler
import com.sky.faraBank.di.initKoin
import component.composeView.CustomText
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.skiko.wasm.onWasmReady
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.events.Event
import sepino.composeapp.generated.resources.Res
import sepino.composeapp.generated.resources.youShouldUNeedMobileForUsePwa
import theme.AppTheme
import utils.LocalLayerContainer


@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    var newVersionAvailable = false
    registerServiceWorker {
        newVersionAvailable = true
        promptUserToRefresh()
    }

    onWasmReady {
        val body = document.body ?: return@onWasmReady
        initKoin()
        hideSplashLoading()
        val userAgent = window.navigator.userAgent
        ComposeViewport(body) {
            CompositionLocalProvider(LocalLayerContainer provides document.body!!) {
                if (userAgent.contains("Android") || userAgent.contains("iPhone")) {
                    App(
                        backPressHandler = backPressHandler,
                        newVersionAvailable = newVersionAvailable
                    )
                } else {
                    AppTheme {
                        DesktopRestriction()
                    }
                }
            }
        }
    }

    handleBrowserBackPress()
}


private val backPressHandler = BackPressHandler()
private fun handleBrowserBackPress() {
    // Add an event listener for the 'popstate' event
    window.addEventListener("popstate", {
        // Call the callback when back press is detected
        backPressHandler.triggerBackPress()
    })
}
