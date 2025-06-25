package navigation.destinations

import kotlinx.serialization.Serializable

@Serializable
data object CharityDestination {
    const val ROUTE = "charity"
}

@Serializable
data class WebViewDestination(val url: String) {
    companion object {
        const val ROUTE = "webView"
    }
}