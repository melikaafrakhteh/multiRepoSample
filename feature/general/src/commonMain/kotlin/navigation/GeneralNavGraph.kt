package navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import view.webView.WebViewPage


fun NavGraphBuilder.generalNavGraph(url: String) {
    composable(
        route = "webview?url={url}",
        arguments = listOf(
            navArgument("url") {
                type = NavType.StringType
                nullable = true
                defaultValue = ""
            }
        )
    ) {
        WebViewPage(url)
    }
}