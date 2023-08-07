package kr.toongether.my.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kr.toongether.my.MyRoute

const val MyRoute = "my_route"

fun NavController.navigateToMy(navOptions: NavOptions? = null) {
    this.navigate(MyRoute, navOptions)
}

fun NavGraphBuilder.myScreen() {
    composable(route = MyRoute) {
        MyRoute()
    }
}
