package kr.toongether.series.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kr.toongether.series.SerialRoute

const val seriesRoute = "series_route"

fun NavController.navigateToSeries(navOptions: NavOptions? = null) {
    this.navigate(seriesRoute, navOptions)
}

fun NavGraphBuilder.seriesScreen() {
    composable(route = seriesRoute) {
        SerialRoute()
    }
}