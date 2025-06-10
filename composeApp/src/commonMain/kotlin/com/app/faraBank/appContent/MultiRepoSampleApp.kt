package com.app.faraBank.appContent

import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import const.Constants
import navigation.charityNavGraph
import navigation.destinations.CharityDestination
import navigation.destinations.CollectLatestOnStart
import navigation.generalNavGraph
import theme.AppTheme

@Composable
fun MultiRepoSampleApp(backPressHandler: BackPressHandler) {
    val navController = rememberNavController()

    AppTheme {
        NavHost(
            navController = navController,
            startDestination = CharityDestination
        ) {
            charityNavGraph(navController)
            generalNavGraph(Constants.MAHAK_CHARITY_URL)
        }

        CollectLatestOnStart(backPressHandler.onBackPressed) {
            handleBackPressed(
                navHostController = navController,
                exitApp = { },
            )
        }
    }
}

private fun handleBackPressed(
    navHostController: NavHostController,
    exitApp: () -> Unit,
) {
    navHostController.currentBackStackEntry?.destination.let { currentDestination ->
        when {
            currentDestination?.hasRoute(
                CharityDestination::class
            ) == true -> exitApp()

            else -> navHostController.popBackStack()
        }
    }
}

@Composable
expect fun KeyboardAware(content: @Composable () -> Unit)