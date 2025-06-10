package view.webView

import utils.HtmlView

@androidx.compose.runtime.Composable
actual fun WebViewContent(
    url: String,
    modifier: androidx.compose.ui.Modifier,
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