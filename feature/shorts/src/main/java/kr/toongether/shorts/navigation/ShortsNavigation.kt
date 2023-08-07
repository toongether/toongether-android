package kr.toongether.shorts.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kr.toongether.shorts.ShortsRoute

const val shortsRoute = "shorts_route"

fun NavController.navigateToShorts(navOptions: NavOptions? = null) {
    this.navigate(shortsRoute, navOptions)
}

fun NavGraphBuilder.shortsScreen() {
    composable(route = shortsRoute) {
        ShortsRoute()
    }
}