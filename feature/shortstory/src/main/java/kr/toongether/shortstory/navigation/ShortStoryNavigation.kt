package kr.toongether.shortstory.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kr.toongether.shortstory.ShortStoryRoute

const val shortStoryRoute = "short_story_route"

fun NavController.navigateToShortStory(navOptions: NavOptions? = null) {
    this.navigate(shortStoryRoute, navOptions)
}

fun NavGraphBuilder.shortStoryScreen() {
    composable(route = shortStoryRoute) {
        ShortStoryRoute()
    }
}