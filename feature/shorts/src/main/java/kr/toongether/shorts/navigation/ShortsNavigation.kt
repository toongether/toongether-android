package kr.toongether.shorts.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kr.toongether.shorts.ShortsRoute

const val ShortsRoute = "shorts_route"

fun NavController.navigateToShorts(navOptions: NavOptions? = null) {
    this.navigate(ShortsRoute, navOptions)
}

fun NavGraphBuilder.shortsScreen(navController: NavController) {
    composable(route = ShortsRoute) {
        ShortsRoute(navController = navController)
    }
}
