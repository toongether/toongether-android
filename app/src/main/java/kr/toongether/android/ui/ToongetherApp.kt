package kr.toongether.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import kr.toongether.android.navigation.NavigationDestination
import kr.toongether.android.navigation.ToongetherNavHost
import kr.toongether.designsystem.component.ToongetherNavigationBar
import kr.toongether.designsystem.component.ToongetherNavigationBarItem
import kr.toongether.designsystem.theme.Gray
import kr.toongether.designsystem.theme.pretendard

@Composable
fun ToongetherApp(
    appState: ToongetherAppState = rememberToongetherAppState()
) {
    var alert: (@Composable () -> Unit) by remember { mutableStateOf({}) }

    Box {
        Scaffold(
            containerColor = Color.Transparent,
            bottomBar = {
                if (appState.isShowBottomBar) {
                    ToongetherBottomBar(
                        destinations = appState.navigationDestinations,
                        onNavigateToDestination = appState::navigateToNavigationDestination,
                        currentDestination = appState.currentDestination,
                        isShowBottomBar = appState.isShowBottomBar
                    )
                }
            }
        ) { paddingValues ->
            Surface(
                modifier = if (appState.isShowBottomBar) {
                    Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                        .padding(bottom = paddingValues.calculateBottomPadding())
                } else {
                    Modifier
                        .fillMaxSize()
                },
                color = Color.Black
            ) {
                ToongetherNavHost(
                    appState = appState,
                    alert = { alert = it }
                )
            }
        }

        alert.invoke()
    }
}

@Composable
private fun ToongetherBottomBar(
    destinations: List<NavigationDestination>,
    onNavigateToDestination: (NavigationDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
    isShowBottomBar: Boolean
) {
    ToongetherNavigationBar(
        modifier = if (isShowBottomBar) {
            modifier
                .background(Color.Black)
                .navigationBarsPadding()
        } else {
            modifier
        }
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isNavigationDestinationInHierarchy(destination)
            ToongetherNavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    Icon(
                        modifier = modifier.size(24.dp),
                        imageVector = destination.icon,
                        contentDescription = null,
                        tint = if (selected) Color.White else Gray
                    )
                },
                label = {
                    Text(
                        text = stringResource(destination.iconTextId),
                        fontSize = 10.sp,
                        fontFamily = pretendard,
                        fontWeight = FontWeight.Medium,
                        color = if (selected) Color.White else Gray
                    )
                }
            )
        }
    }
}

private fun NavDestination?.isNavigationDestinationInHierarchy(destination: NavigationDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
