package kr.toongether.comic.navigation

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import kr.toongether.comic.ComicRoute
import kr.toongether.model.Shorts

const val ComicRoute = "comic_route/{id}/{title}/{writer}"

fun NavController.navigateToComic(shorts: Shorts, navOptions: NavOptions? = null) {
    this.navigate("comic_route/${shorts.id}/${shorts.title}/${shorts.writer}", navOptions)
    Log.d("TEST", shorts.id.toString())
}

fun NavGraphBuilder.comicScreen(navController: NavController) {
    composable(
        route = ComicRoute,
        arguments = listOf(
            navArgument("id") { type = NavType.LongType },
            navArgument("title") { type = NavType.StringType },
            navArgument("writer") { type = NavType.StringType }
        )
    ) {
        ComicRoute(
            navController = navController,
            id = it.arguments?.getLong("id") ?: 0L,
            title = it.arguments?.getString("title") ?: "",
            writer = it.arguments?.getString("writer") ?: ""
        )
    }
}
