package kr.toongether.episode.navigatoin

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import kr.toongether.episode.EpisodeScreen

const val EpisodeRoute = "episode_route/{id}"

fun NavController.navigateToEpisode(id: Long, navOptions: NavOptions? = null) {
    this.navigate("episode_route/$id", navOptions)
}

@ExperimentalMaterial3Api
fun NavGraphBuilder.episodeScreen(
    navigateToComic: (Long, Int) -> Unit,
    popBackStack: () -> Unit
) {
    composable(
        route = EpisodeRoute,
        arguments = listOf(navArgument("id") { type = NavType.LongType }),
        enterTransition = {
            when (initialState.destination.route) {
                "series_route", "home_route" -> slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(durationMillis = 400)
                )
                else -> null
            }
        },
        exitTransition = {
            when (targetState.destination.route) {
                "series_route", "home_route" -> slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(durationMillis = 400)
                )
                else -> null
            }
        }
    ) {
        EpisodeScreen(
            id = it.arguments?.getLong("id") ?: 0L,
            navigateToComic = navigateToComic,
            popBackStack = popBackStack
        )
    }
}
