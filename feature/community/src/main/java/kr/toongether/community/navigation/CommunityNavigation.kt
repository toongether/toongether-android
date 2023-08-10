package kr.toongether.community.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import kr.toongether.community.CommunityRoute

const val CommunityRoute = "community_route"

fun NavController.navigateToCommunity(navOptions: NavOptions? = null) {
    this.navigate(CommunityRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.communityScreen() {
    composable(route = CommunityRoute) {
        CommunityRoute()
    }
}
