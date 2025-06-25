package navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import const.Constants
import navigation.destinations.WebViewDestination
import view.CharityPage


fun NavGraphBuilder.charityNavGraph(navController: NavController) {
    composable(Constants.CHARITY_TEXT) {
        CharityPage(
            onClickOpenWebView = {
                navController.navigate(WebViewDestination.ROUTE)
            }
        )
    }
}