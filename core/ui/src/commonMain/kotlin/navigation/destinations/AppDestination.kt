package navigation.destinations

import kotlinx.serialization.Serializable

@Serializable
data object CharityDestination

@Serializable
data class WebViewDestination(val url: String)