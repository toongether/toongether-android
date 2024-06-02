package kr.toongether.main.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kr.toongether.main.MainScreen

const val MAIN_ROUTE = "main_route"

fun NavController.navigateToMain(navOptions: NavOptions? = null) {
    this.navigate(MAIN_ROUTE, navOptions)
}

@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.mainScreen(
    navigateToEpisode: (Long, String, String) -> Unit,
    navigateToLogin: () -> Unit,
    sharedTransitionScope: SharedTransitionScope,
) {
    composable(route = MAIN_ROUTE) {
        MainScreen(
            navigateToEpisode = navigateToEpisode,
            navigateToLogin = navigateToLogin,
            sharedTransitionScope = sharedTransitionScope,
            animatedContentScope = this@composable
        )
    }
}
