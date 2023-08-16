package kr.toongether.login.navigation

import androidx.compose.animation.ExperimentalAnimationApi
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
fun NavGraphBuilder.loginScreen(navController: NavController) {
    composable(route = LoginRoute) {
        LoginRoute(navController = navController)
    }
}
