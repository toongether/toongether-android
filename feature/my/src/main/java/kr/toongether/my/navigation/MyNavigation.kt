package kr.toongether.my.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import kr.toongether.my.MyRoute

const val MyRoute = "my_route"

fun NavController.navigateToMy(navOptions: NavOptions? = null) {
    this.navigate(MyRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.myScreen(navController: NavController) {
    composable(route = MyRoute) {
        MyRoute(navController = navController)
    }
}
