package kr.toongether.episode.navigatoin

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import kr.toongether.episode.EpisodeRoute

const val EpisodeRoute = "episode_route"

fun NavController.navigateToEpisode(navOptions: NavOptions? = null) {
    this.navigate(EpisodeRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.episodeScreen(navController: NavController) {
    composable(route = EpisodeRoute) {
        EpisodeRoute(navController = navController)
    }
}
