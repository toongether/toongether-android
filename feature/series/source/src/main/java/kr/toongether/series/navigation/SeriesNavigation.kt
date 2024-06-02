package kr.toongether.series.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
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

@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.seriesScreen(
    navigateToEpisode: (Long, String, String) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    composable(route = SERIES_ROUTE) {
        SeriesScreen(
            navigateToEpisode = navigateToEpisode,
            sharedTransitionScope = sharedTransitionScope,
            animatedContentScope = animatedContentScope
        )
    }
}
