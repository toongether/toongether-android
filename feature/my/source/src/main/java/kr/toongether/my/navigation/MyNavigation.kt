package kr.toongether.my.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kr.toongether.my.MyRoute

const val MyRoute = "my_route"
const val SettingRoute = "setting_route"
internal const val QuitAccountRoute = "quit_account_route"

fun NavController.navigateToMy(navOptions: NavOptions? = null) {
    this.navigate(MyRoute, navOptions)
}

fun NavGraphBuilder.myScreen() {
    composable(route = MyRoute) {
        MyRoute()
    }
}
//
//fun NavController.navigateToSetting(navOptions: NavOptions? = null) {
//    this.navigate(SettingRoute, navOptions)
//}
//
//internal fun NavController.navigateToQuitAccount(navOptions: NavOptions? = null) {
//    this.navigate(QuitAccountRoute, navOptions)
//}
//
//fun NavGraphBuilder.settingScreen(
//    navController: NavController,
//    alert: (@Composable () -> Unit) -> Unit
//) {
//    composable(
//        route = SettingRoute,
//        enterTransition = {
//            when (initialState.destination.route) {
//                MyRoute -> slideIntoContainer(
//                    AnimatedContentTransitionScope.SlideDirection.Left,
//                    animationSpec = tween(durationMillis = 400)
//                )
//
//                else -> null
//            }
//        },
//        exitTransition = {
//            when (targetState.destination.route) {
//                MyRoute -> slideOutOfContainer(
//                    AnimatedContentTransitionScope.SlideDirection.Right,
//                    animationSpec = tween(durationMillis = 400)
//                )
//
//                else -> null
//            }
//        }
//    ) {
//        SettingRoute(navController = navController, alert = alert)
//    }
//
//    composable(
//        route = QuitAccountRoute,
//        enterTransition = {
//            when (initialState.destination.route) {
//                SettingRoute -> slideIntoContainer(
//                    AnimatedContentTransitionScope.SlideDirection.Left,
//                    animationSpec = tween(durationMillis = 400)
//                )
//
//                else -> null
//            }
//        },
//        exitTransition = {
//            when (targetState.destination.route) {
//                SettingRoute -> slideOutOfContainer(
//                    AnimatedContentTransitionScope.SlideDirection.Right,
//                    animationSpec = tween(durationMillis = 400)
//                )
//
//                else -> null
//            }
//        }
//    ) {
//        QuitAccountRoute(navController = navController, alert = alert)
//    }
//}
