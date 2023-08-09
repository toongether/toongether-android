package kr.toongether.shorts.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import kr.toongether.shorts.ShortsRoute

const val ShortsRoute = "shorts_route"

fun NavController.navigateToShorts(navOptions: NavOptions? = null) {
    this.navigate(ShortsRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.shortsScreen(navController: NavController) {
    composable(route = ShortsRoute,) {
        ShortsRoute(navController = navController)
    }
}
