package view.webView


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WebViewPage(
    url: String
) {
    WebViewScreen(
        url = url
    )
}

@Composable
private fun WebViewScreen(
    url: String
) {
    Box(modifier = Modifier.fillMaxSize()) {
        WebViewContent(
            modifier = Modifier.fillMaxSize(),
            url = url,
        )
    }
}

@Composable
expect fun WebViewContent(
    url: String,
    modifier: Modifier = Modifier,
)