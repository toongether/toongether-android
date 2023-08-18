package kr.toongether.signup.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable
import kr.toongether.signup.CheckEmailRoute
import kr.toongether.signup.InputPasswordRoute
import kr.toongether.signup.SignupRoute

const val SignupRoute = "signup_route"
const val CheckEmailRoute = "check_email_route/{email}"
const val InputPasswordRoute = "input_password_route"

fun NavController.navigateToSignup(navOptions: NavOptions? = null) {
    this.navigate(SignupRoute, navOptions)
}

internal fun NavController.navigateToCheckEmail(email: String, navOptions: NavOptions? = null) {
    this.navigate("check_email_route/$email", navOptions)
}

internal fun NavController.navigateToInputPassword(navOptions: NavOptions? = null) {
    this.navigate(InputPasswordRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.signupScreen(navController: NavController) {
    composable(route = SignupRoute) {
        SignupRoute(navController = navController)
    }
    composable(
        route = CheckEmailRoute,
        arguments = listOf(
            navArgument("email") { type = NavType.StringType }
        ),
        enterTransition = {
            slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(durationMillis = 400))
        },
        exitTransition = {
            slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(durationMillis = 400))
        }
    ) {
        CheckEmailRoute(
            navController = navController,
            email = it.arguments?.getString("email") ?: ""
        )
    }
    composable(route = InputPasswordRoute) {
        InputPasswordRoute(navController = navController)
    }
}
