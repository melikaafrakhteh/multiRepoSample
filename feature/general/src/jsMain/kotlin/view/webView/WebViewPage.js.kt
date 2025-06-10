package view.webView

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import utils.HtmlView

//TODO: add loading
@Composable
actual fun WebViewContent(
    url: String,
    modifier: Modifier,
    onLoadingStateChanged: (Boolean) -> Unit
) {
    HtmlView(
        modifier = modifier,
        factory = {
            val iframe = createElement("iframe")
            iframe.setAttribute("src", url)  // Replace with the desired page URL
            iframe.setAttribute("width", "100%")
            iframe.setAttribute("height", "100%")
            iframe.setAttribute("frameborder", "0")
            iframe.setAttribute("allowfullscreen", "")
            iframe
        }
    )
}