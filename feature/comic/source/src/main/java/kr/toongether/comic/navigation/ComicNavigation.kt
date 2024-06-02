package kr.toongether.comic.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import kr.toongether.comic.ComicScreen

const val COMIC_ROUTE = "comic_route/{seriesId}/{episodeNumber}"

fun NavController.navigateToComic(
    seriesId: Long,
    episodeNumber: Int,
    navOptions: NavOptions? = null
) {
    this.navigate("comic_route/$seriesId/$episodeNumber", navOptions)
}

fun NavGraphBuilder.comicScreen(
    navigateToComic: (seriesId: Long, episodeNumber: Int) -> Unit,
    navigateToLogin: () -> Unit,
    popBackStack: () -> Unit,
) {
    composable(
        route = COMIC_ROUTE,
        arguments = listOf(
            navArgument("seriesId") { type = NavType.LongType },
            navArgument("episodeNumber") { type = NavType.LongType }
        ),
        enterTransition = {
            when (initialState.destination.route) {
                "episode_route/{id}" -> slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(durationMillis = 400)
                )

                "shorts_route", "home_route" -> slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(durationMillis = 400)
                )

                else -> null
            }
        },
        exitTransition = {
            when (targetState.destination.route) {
                "episode_route/{id}" -> slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(durationMillis = 400)
                )

                "shorts_route", "home_route" -> slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(durationMillis = 400)
                )

                else -> null
            }

        }
    ) {
        val seriesId = it.arguments?.getLong("seriesId") ?: 0L
        ComicScreen(
            seriesId = seriesId,
            episodeNumber = it.arguments?.getLong("episodeNumber") ?: 0L,
            navigateToComic = { id -> navigateToComic(seriesId, id.toInt()) },
            navigateToLogin = navigateToLogin,
            popBackStack = popBackStack
        )
    }
}
