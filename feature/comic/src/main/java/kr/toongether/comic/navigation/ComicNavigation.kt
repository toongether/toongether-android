package kr.toongether.comic.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable
import kr.toongether.comic.ComicRoute

const val ComicRoute = "comic_route/{seriesId}/{episodeNumber}"

fun NavController.navigateToComic(shortsId: Long, navOptions: NavOptions? = null) {
    this.navigate("comic_route/-1/$shortsId", navOptions)
}

fun NavController.navigateToComic(
    seriesId: Long,
    episodeNumber: Long,
    navOptions: NavOptions? = null
) {
    this.navigate("comic_route/$seriesId/$episodeNumber", navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.comicScreen(navController: NavController) {
    composable(
        route = ComicRoute,
        arguments = listOf(
            navArgument("seriesId") { type = NavType.LongType },
            navArgument("episodeNumber") { type = NavType.LongType },
        ),
        enterTransition = {
            when (initialState.destination.route) {
                "episode_route/{id}" -> slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(durationMillis = 400)
                )
                "shorts_route" -> slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(durationMillis = 400)
                )
                else -> null
            }
        },

        exitTransition = {
            when (targetState.destination.route) {
                "episode_route/{id}" -> slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(durationMillis = 400)
                )
                "shorts_route" -> slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(durationMillis = 400)
                )
                else -> null
            }
        }
    ) {
        ComicRoute(
            navController = navController,
            seriesId = it.arguments?.getLong("seriesId") ?: 0L,
            episodeNumber = it.arguments?.getLong("episodeNumber") ?: 0L,
        )
    }
}
