package kr.toongether.episode.navigatoin

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable
import kr.toongether.episode.EpisodeRoute

const val EpisodeRoute = "episode_route/{id}"

fun NavController.navigateToEpisode(id: Long, navOptions: NavOptions? = null) {
    this.navigate("episode_route/$id", navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.episodeScreen(navController: NavController) {
    composable(
        route = EpisodeRoute,
        arguments = listOf(navArgument("id") { type = NavType.LongType }),
        enterTransition = {
            slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(durationMillis = 400))
        },
        exitTransition = {
            slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(durationMillis = 400))
        }
    ) {
        EpisodeRoute(
            id = it.arguments?.getLong("id") ?: 0L,
            navController = navController
        )
    }
}
