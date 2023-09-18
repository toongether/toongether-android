package kr.toongether.my.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import kr.toongether.my.MyRoute
import kr.toongether.my.QuitAccountRoute
import kr.toongether.my.SettingRoute

const val MyRoute = "my_route"
const val SettingRoute = "setting_route"
internal const val QuitAccountRoute = "quit_account_route"

fun NavController.navigateToMy(navOptions: NavOptions? = null) {
    this.navigate(MyRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.myScreen(navController: NavController) {
    composable(route = MyRoute) {
        MyRoute(navController = navController)
    }
}

fun NavController.navigateToSetting(navOptions: NavOptions? = null) {
    this.navigate(SettingRoute, navOptions)
}

internal fun NavController.navigateToQuitAccount(navOptions: NavOptions? = null) {
    this.navigate(QuitAccountRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.settingScreen(
    navController: NavController,
    alert: (@Composable () -> Unit) -> Unit,
) {
    composable(
        route = SettingRoute,
        enterTransition = {
            when (initialState.destination.route) {
                MyRoute -> slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(durationMillis = 400)
                )

                else -> null
            }
        },
        exitTransition = {
            when (targetState.destination.route) {
                MyRoute -> slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(durationMillis = 400)
                )

                else -> null
            }
        }
    ) {
        SettingRoute(navController = navController, alert = alert)
    }

    composable(
        route = QuitAccountRoute,
        enterTransition = {
            when (initialState.destination.route) {
                SettingRoute -> slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(durationMillis = 400)
                )

                else -> null
            }
        },
        exitTransition = {
            when (targetState.destination.route) {
                SettingRoute -> slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(durationMillis = 400)
                )

                else -> null
            }
        }
    ) {
        QuitAccountRoute(navController = navController, alert = alert)
    }
}
