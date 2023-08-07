package kr.toongether.community.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kr.toongether.community.CommunityRoute

const val CommunityRoute = "community_route"

fun NavController.navigateToCommunity(navOptions: NavOptions? = null) {
    this.navigate(CommunityRoute, navOptions)
}

fun NavGraphBuilder.communityScreen() {
    composable(route = CommunityRoute) {
        CommunityRoute()
    }
}
