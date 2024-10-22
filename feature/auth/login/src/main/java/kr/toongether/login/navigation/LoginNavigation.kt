package kr.toongether.login.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import kr.toongether.login.LoginRoute

const val LoginRoute = "login_route"

fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.navigate(LoginRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.loginScreen(
    navController: NavController,
    alert: (@Composable () -> Unit) -> Unit
) {
    composable(
        route = LoginRoute,
        enterTransition = {
            when (initialState.destination.route) {
                "my_route", "comic_route/{seriesId}/{episodeNumber}", "setting_route" -> slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(durationMillis = 400)
                )
                else -> null
            }
        },
        exitTransition = {
            when (targetState.destination.route) {
                "my_route", "comic_route/{seriesId}/{episodeNumber}", "setting_route" -> slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(durationMillis = 400)
                )
                else -> null
            }
        }
    ) {
        LoginRoute(navController = navController, alert = alert)
    }
}
