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

const val ComicRoute = "comic_route/{seriesId}/{episodeId}/{author}"

fun NavController.navigateToComic(shortsId: Long, author: String, navOptions: NavOptions? = null) {
    this.navigate("comic_route/-1/$shortsId/$author", navOptions)
}

fun NavController.navigateToComic(
    seriesId: Long,
    episodeId: Long,
    author: String,
    navOptions: NavOptions? = null
) {
    this.navigate("comic_route/$seriesId/$episodeId/$author", navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.comicScreen(navController: NavController) {
    composable(
        route = ComicRoute,
        arguments = listOf(
            navArgument("seriesId") { type = NavType.LongType },
            navArgument("episodeId") { type = NavType.LongType },
            navArgument("author") { type = NavType.StringType }
        ),
        enterTransition = {
            slideIntoContainer(
                AnimatedContentScope.SlideDirection.Left,
                animationSpec = tween(durationMillis = 400)
            )
        },

        exitTransition = {
            slideOutOfContainer(
                AnimatedContentScope.SlideDirection.Right,
                animationSpec = tween(durationMillis = 400)
            )
        }
    ) {
        ComicRoute(
            navController = navController,
            seriesId = it.arguments?.getLong("seriesId") ?: 0L,
            episodeId = it.arguments?.getLong("episodeId") ?: 0L,
            writer = it.arguments?.getString("author") ?: ""
        )
    }
}
