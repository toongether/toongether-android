package kr.toongether.shorts.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kr.toongether.shorts.ShortsScreen

const val SHORTS_ROUTE = "shorts_route"

fun NavController.navigateToShorts(navOptions: NavOptions? = null) {
    this.navigate(SHORTS_ROUTE, navOptions)
}

fun NavGraphBuilder.shortsScreen(
    navigateToLogin: () -> Unit,
) {
    composable(route = SHORTS_ROUTE) {
        ShortsScreen(
            navigateToLogin = navigateToLogin,
        )
    }
}
