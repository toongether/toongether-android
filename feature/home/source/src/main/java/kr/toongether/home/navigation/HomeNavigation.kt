package kr.toongether.home.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kr.toongether.home.HomeScreen

const val HomeRoute = "home_route"

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(HomeRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(
    navigateToComic: (shortsId: Long) -> Unit,
    navigateToEpisode: (seriesId: Long) -> Unit,
    alert: (@Composable () -> Unit) -> Unit
) {
    composable(route = HomeRoute) {
        HomeScreen(
            navigateToComic = navigateToComic,
            navigateToEpisode = navigateToEpisode,
            alert = alert
        )
    }
}
