package kr.toongether.signup.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import kr.toongether.signup.CheckEmailRoute
import kr.toongether.signup.InputPasswordRoute
import kr.toongether.signup.SignupRoute

const val SignupRoute = "signup_route"
const val CheckEmailRoute = "check_email_route"
const val InputPasswordRoute = "input_password_route"

fun NavController.navigateToSignup(navOptions: NavOptions? = null) {
    this.navigate(SignupRoute, navOptions)
}

internal fun NavController.navigateToCheckEmail(navOptions: NavOptions? = null) {
    this.navigate(CheckEmailRoute, navOptions)
}

internal fun NavController.navigateToInputPassword(navOptions: NavOptions? = null) {
    this.navigate(InputPasswordRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.signupScreen(navController: NavController) {
    composable(route = SignupRoute) {
        SignupRoute(navController = navController)
    }
    composable(route = CheckEmailRoute) {
        CheckEmailRoute(navController = navController)
    }
    composable(route = InputPasswordRoute) {
        InputPasswordRoute(navController = navController)
    }
}
