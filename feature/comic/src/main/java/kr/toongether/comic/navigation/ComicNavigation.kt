package kr.toongether.comic.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
//import kr.toongether.comic.ComicRoute

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

fun NavGraphBuilder.comicScreen(
    navController: NavController,
    alert: (@Composable () -> Unit) -> Unit
) {
    composable(
        route = ComicRoute,
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
//        ComicRoute(
//            navController = navController,
//            seriesId = it.arguments?.getLong("seriesId") ?: 0L,
//            episodeNumber = it.arguments?.getLong("episodeNumber") ?: 0L,
//            alert = alert
//        )
    }
}
