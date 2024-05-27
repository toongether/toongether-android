package kr.toongether.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import kr.toongether.main.navigation.NavigationDestination

@Stable
class MainScreenState(
    val navController: NavHostController
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val navigationDestinations: List<NavigationDestination> = NavigationDestination.entries

    val isShowBottomBar: Boolean
        @Composable get() = when (currentDestination?.route) {
            HomeRoute, SeriesRoute, ShortsRoute, MyRoute -> true
            else -> false
        }

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
            NavigationDestination.MY -> navController.navigateToMy(navOptions)
        }
    }
}
