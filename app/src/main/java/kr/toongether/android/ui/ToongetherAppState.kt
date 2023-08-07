package kr.toongether.android.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import kr.toongether.android.navigation.NavigationDestination
import kr.toongether.community.navigation.navigateToCommunity
import kr.toongether.home.navigation.navigateToHome
import kr.toongether.my.navigation.navigateToMy
import kr.toongether.series.navigation.navigateToSeries
import kr.toongether.shorts.navigation.navigateToShorts

@Composable
fun rememberToongetherAppState(
    navController: NavHostController = rememberNavController(),
    isShowBottomBar: Boolean = true
): ToongetherAppState {
    return remember(
        navController,
        isShowBottomBar
    ) {
        ToongetherAppState(
            navController,
            isShowBottomBar
        )
    }
}

@Stable
class ToongetherAppState(
    val navController: NavHostController,
    val isShowBottomBar: Boolean
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val navigationDestinations: List<NavigationDestination> = NavigationDestination.values().asList()

    fun navigateToNavigationDestination(navigationDestination: NavigationDestination) {
        val navOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (navigationDestination) {
            NavigationDestination.HOME -> navController.navigateToHome(navOptions)
            NavigationDestination.SERIES -> navController.navigateToSeries(navOptions)
            NavigationDestination.SHORTS -> navController.navigateToShorts(navOptions)
            NavigationDestination.COMMUNITY -> navController.navigateToCommunity(navOptions)
            NavigationDestination.MY -> navController.navigateToMy(navOptions)
        }
    }
}
