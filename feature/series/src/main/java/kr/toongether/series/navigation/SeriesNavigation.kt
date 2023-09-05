package kr.toongether.series.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import kr.toongether.series.SeriesRoute

const val SeriesRoute = "series_route"

fun NavController.navigateToSeries(navOptions: NavOptions? = null) {
    this.navigate(SeriesRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.seriesScreen(navController: NavController) {
    composable(route = SeriesRoute) {
        SeriesRoute(navController = navController)
    }
}
