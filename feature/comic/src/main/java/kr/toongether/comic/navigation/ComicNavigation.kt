package kr.toongether.comic.navigation

import android.util.Log
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
import kr.toongether.model.Shorts

const val ComicRoute = "comic_route/{id}/{title}/{writer}"

fun NavController.navigateToComic(shorts: Shorts, navOptions: NavOptions? = null) {
    this.navigate("comic_route/${shorts.id}/${shorts.title}/${shorts.writer}", navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.comicScreen(navController: NavController) {
    composable(
        route = ComicRoute,
        arguments = listOf(
            navArgument("id") { type = NavType.LongType },
            navArgument("title") { type = NavType.StringType },
            navArgument("writer") { type = NavType.StringType }
        ),
        enterTransition = {
            slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(durationMillis = 400))
        },
        exitTransition = {
            slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(durationMillis = 400))
        }
    ) {
        ComicRoute(
            navController = navController,
            id = it.arguments?.getLong("id") ?: 0L,
            title = it.arguments?.getString("title") ?: "",
            writer = it.arguments?.getString("writer") ?: ""
        )
    }
}
