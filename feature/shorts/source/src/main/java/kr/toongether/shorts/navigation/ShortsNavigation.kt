package kr.toongether.shorts.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kr.toongether.shorts.ShortsScreen

const val ShortsRoute = "shorts_route"

fun NavController.navigateToShorts(navOptions: NavOptions? = null) {
    this.navigate(ShortsRoute, navOptions)
}

@ExperimentalMaterial3Api
@ExperimentalMaterialApi
fun NavGraphBuilder.shortsScreen(navigateToComic: (shortsId: Long) -> Unit) {
    composable(route = ShortsRoute) {
        ShortsScreen(navigateToComic = navigateToComic)
    }
}
