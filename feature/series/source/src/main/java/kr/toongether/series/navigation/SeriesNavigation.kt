package kr.toongether.series.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kr.toongether.series.SeriesScreen

const val SERIES_ROUTE = "series_route"

fun NavController.navigateToSeries(navOptions: NavOptions? = null) {
    this.navigate(SERIES_ROUTE, navOptions)
}

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
fun NavGraphBuilder.seriesScreen(navigateToEpisode: (episodeId: Long) -> Unit) {
    composable(route = SERIES_ROUTE) {
        SeriesScreen(navigateToEpisode = navigateToEpisode)
    }
}
