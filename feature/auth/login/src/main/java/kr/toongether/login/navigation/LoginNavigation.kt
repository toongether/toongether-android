package kr.toongether.login.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kr.toongether.login.LoginRoute

const val LOGIN_ROUTE = "login_route"

fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.navigate(LOGIN_ROUTE, navOptions)
}

fun NavGraphBuilder.loginScreen(popBackStack: () -> Unit) {
    composable(
        route = LOGIN_ROUTE,
        enterTransition = {
            when (initialState.destination.route) {
                "my_route", "comic_route/{seriesId}/{episodeNumber}", "setting_route", "main_route" -> slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(durationMillis = 400)
                )

                else -> null
            }
        },
        exitTransition = {
            when (targetState.destination.route) {
                "my_route", "comic_route/{seriesId}/{episodeNumber}", "setting_route", "main_route" -> slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(durationMillis = 400)
                )

                else -> null
            }
        }
    ) {
        LoginRoute(
            onClickSignup = {},
            onBackClick = popBackStack
        )
    }
}
