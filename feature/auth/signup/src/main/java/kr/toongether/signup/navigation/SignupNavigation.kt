//package kr.toongether.signup.navigation
//
//import androidx.compose.animation.AnimatedContentTransitionScope
//import androidx.compose.animation.core.tween
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavController
//import androidx.navigation.NavGraphBuilder
//import androidx.navigation.NavOptions
//import androidx.navigation.NavType
//import androidx.navigation.compose.composable
//import androidx.navigation.navArgument
//import kr.toongether.signup.AgreeRoute
//import kr.toongether.signup.CheckEmailRoute
//import kr.toongether.signup.InputPasswordRoute
//import kr.toongether.signup.SignupRoute
//
//const val SignupRoute = "signup_route"
//const val CheckEmailRoute = "check_email_route/{name}/{userId}/{email}"
//const val InputPasswordRoute = "input_password_route/{name}/{userId}/{email}/{code}"
//const val AgreeRoute = "agree_route"
//
//fun NavController.navigateToSignup(navOptions: NavOptions? = null) {
//    this.navigate(SignupRoute, navOptions)
//}
//
//internal fun NavController.navigateToCheckEmail(
//    name: String,
//    userId: String,
//    email: String,
//    navOptions: NavOptions? = null
//) {
//    this.navigate("check_email_route/$name/$userId/$email", navOptions)
//}
//
//internal fun NavController.navigateToInputPassword(
//    name: String,
//    userId: String,
//    email: String,
//    code: String,
//    navOptions: NavOptions? = null
//) {
//    this.navigate("input_password_route/$name/$userId/$email/$code", navOptions)
//}
//
//fun NavController.navigateToAgree(navOptions: NavOptions? = null) {
//    this.navigate(AgreeRoute, navOptions)
//}
//
//fun NavGraphBuilder.signupScreen(
//    navController: NavController,
//    alert: (@Composable () -> Unit) -> Unit
//) {
//    composable(
//        route = SignupRoute,
//        enterTransition = {
//            when (initialState.destination.route) {
//                AgreeRoute -> slideIntoContainer(
//                    AnimatedContentTransitionScope.SlideDirection.Left,
//                    animationSpec = tween(durationMillis = 400)
//                )
//
//                else -> null
//            }
//        },
//        exitTransition = {
//            when (targetState.destination.route) {
//                AgreeRoute -> slideOutOfContainer(
//                    AnimatedContentTransitionScope.SlideDirection.Right,
//                    animationSpec = tween(durationMillis = 400)
//                )
//
//                else -> null
//            }
//        }
//    ) {
//        SignupRoute(
//            navController = navController,
//            alert = alert
//        )
//    }
//    composable(
//        route = CheckEmailRoute,
//        arguments = listOf(
//            navArgument("email") { type = NavType.StringType },
//            navArgument("userId") { type = NavType.StringType },
//            navArgument("name") { type = NavType.StringType }
//        ),
//        enterTransition = {
//            slideIntoContainer(
//                AnimatedContentTransitionScope.SlideDirection.Left,
//                animationSpec = tween(durationMillis = 400)
//            )
//        },
//        exitTransition = {
//            slideOutOfContainer(
//                AnimatedContentTransitionScope.SlideDirection.Right,
//                animationSpec = tween(durationMillis = 400)
//            )
//        }
//    ) {
//        CheckEmailRoute(
//            navController = navController,
//            email = it.arguments?.getString("email") ?: "",
//            name = it.arguments?.getString("name") ?: "",
//            userId = it.arguments?.getString("userId") ?: "",
//            alert = alert
//        )
//    }
//    composable(
//        route = InputPasswordRoute,
//        arguments = listOf(
//            navArgument("email") { type = NavType.StringType },
//            navArgument("userId") { type = NavType.StringType },
//            navArgument("name") { type = NavType.StringType },
//            navArgument("code") { type = NavType.StringType }
//        ),
//        enterTransition = {
//            slideIntoContainer(
//                AnimatedContentTransitionScope.SlideDirection.Left,
//                animationSpec = tween(durationMillis = 400)
//            )
//        },
//        exitTransition = {
//            slideOutOfContainer(
//                AnimatedContentTransitionScope.SlideDirection.Right,
//                animationSpec = tween(durationMillis = 400)
//            )
//        }
//    ) {
//        InputPasswordRoute(
//            navController = navController,
//            name = it.arguments?.getString("name") ?: "",
//            userId = it.arguments?.getString("userId") ?: "",
//            email = it.arguments?.getString("email") ?: "",
//            code = it.arguments?.getString("code") ?: "",
//            alert = alert
//        )
//    }
//    composable(
//        route = AgreeRoute,
//        enterTransition = {
//            when (initialState.destination.route) {
//                "login_route" -> slideIntoContainer(
//                    AnimatedContentTransitionScope.SlideDirection.Left,
//                    animationSpec = tween(durationMillis = 400)
//                )
//
//                else -> null
//            }
//        },
//        exitTransition = {
//            when (targetState.destination.route) {
//                "login_route" -> slideOutOfContainer(
//                    AnimatedContentTransitionScope.SlideDirection.Right,
//                    animationSpec = tween(durationMillis = 400)
//                )
//
//                else -> null
//            }
//        }
//    ) {
//        AgreeRoute(navController = navController)
//    }
//}
