package kr.toongether.my.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import kr.toongether.my.MyRoute
import kr.toongether.my.SettingRoute

const val MyRoute = "my_route"
const val SettingRoute = "setting_route"

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

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.settingScreen(navController: NavController) {
    composable(
        route = SettingRoute,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentScope.SlideDirection.Left,
                animationSpec = tween(durationMillis = 400)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentScope.SlideDirection.Right,
                animationSpec = tween(durationMillis = 400)
            )
        }
    ) {
        SettingRoute(navController = navController)
    }
}
