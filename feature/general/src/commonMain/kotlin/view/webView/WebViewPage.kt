package view.webView


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
    var isLoading by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator()

        } else {
            WebViewContent(
                modifier = Modifier.fillMaxSize(),
                url = url,
                onLoadingStateChanged = {
                    isLoading = it
                }
            )
        }
    }
}

@Composable
expect fun WebViewContent(
    url: String,
    modifier: Modifier = Modifier,
    onLoadingStateChanged: (Boolean) -> Unit
)