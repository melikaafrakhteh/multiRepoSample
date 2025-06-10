package com.sky.faraBank.appContent.app

import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sky.faraBank.deepLinkHandler.DeepLinkHandler
import kotlinx.browser.window
import org.w3c.dom.events.EventListener
import org.w3c.dom.url.URL

@Composable
actual fun KeyboardAware(content: @Composable () -> Unit) {
    var isKeyboardOpen by remember { mutableStateOf(false) }
    var keyboardHeight by remember { mutableStateOf(0) }
    val windowHeight by remember { mutableStateOf(window.innerHeight) }

    DisposableEffect(Unit) {
        val resizeListener = EventListener {
            val viewport = window.asDynamic().visualViewport
            val currentHeight = if (viewport != null) {
                viewport.height as Int // Use visualViewport for accurate height
            } else {
                window.innerHeight // Fallback to window.innerHeight
            }

            val newKeyboardHeight = windowHeight - currentHeight
            keyboardHeight = if (newKeyboardHeight > 0) newKeyboardHeight else 0
            isKeyboardOpen = keyboardHeight > 150 // Heuristic threshold
        }

        // Add listeners for both resize and visualViewport resize
        window.addEventListener("resize", resizeListener)
        window.asDynamic().visualViewport?.addEventListener("resize", resizeListener)

        listenForDeepLink()

        onDispose {
            window.removeEventListener("resize", resizeListener)
            window.asDynamic().visualViewport?.removeEventListener("resize", resizeListener)
        }
    }
    val scrollState = rememberScrollState()

    Box(modifier = Modifier.padding(bottom = if (isKeyboardOpen) keyboardHeight.dp else 0.dp)) {
        content()
        VerticalScrollbar(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .fillMaxHeight(),
            adapter = rememberScrollbarAdapter(scrollState)
        )
    }
}

fun listenForDeepLink() {
    val href = window.location.href
    val urlObj = URL(href)

    val queryParams = urlObj.searchParams
    val paramMap = mutableMapOf<String, String>()

    // Iterate through all the query parameters by using getAll with known keys
    val keys = js("Array.from(queryParams.keys())") as Array<String>
    for (key in keys) {
        val value = queryParams.get(key) ?: ""
        paramMap[key] = value
    }
    queryParams.get("destination")?.let {
        DeepLinkHandler.onNewUri(it)
    }
}