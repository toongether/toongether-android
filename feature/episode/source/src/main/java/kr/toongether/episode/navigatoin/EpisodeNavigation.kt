package kr.toongether.episode.navigatoin

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import kr.toongether.episode.EpisodeScreen
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

const val EPISODE_ROUTE = "episode_route/{id}/{backgroundColor}/{backgroundImage}"

fun NavController.navigateToEpisode(
    id: Long,
    backgroundColor: String,
    backgroundImage: String,
    navOptions: NavOptions? = null
) {
    val encodedUrl = URLEncoder.encode(backgroundImage, StandardCharsets.UTF_8.toString())
    this.navigate("episode_route/$id/$backgroundColor/$encodedUrl", navOptions)
}

@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.episodeScreen(
    navigateToComic: (Long, Int) -> Unit,
    popBackStack: () -> Unit,
    sharedTransitionScope: SharedTransitionScope,
) {
    composable(
        route = EPISODE_ROUTE,
        arguments = listOf(
            navArgument("id") { type = NavType.LongType },
            navArgument("backgroundColor") { type = NavType.StringType },
            navArgument("backgroundImage") { type = NavType.StringType },
        ),
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
            popBackStack = popBackStack,
            backgroundColor = it.arguments?.getString("backgroundColor") ?: "#FFFFFF",
            backgroundImage = it.arguments?.getString("backgroundImage") ?: "",
            sharedTransitionScope = sharedTransitionScope,
            animatedContentScope = this@composable
        )
    }
}
