package kr.toongether.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import kr.toongether.designsystem.component.ToongetherNavigationBar
import kr.toongether.designsystem.component.ToongetherNavigationBarItem
import kr.toongether.designsystem.theme.Gray
import kr.toongether.designsystem.theme.pretendard
import kr.toongether.main.navigation.NavigationDestination

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        bottomBar = {
            ToongetherBottomBar(
                destinations = ,
                onNavigateToDestination = ,
                currentDestination = 
            )
        }
    ) { paddingValues ->

    }
}


@Composable
private fun ToongetherBottomBar(
    destinations: List<NavigationDestination>,
    onNavigateToDestination: (NavigationDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    ToongetherNavigationBar(
        modifier = modifier
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isNavigationDestinationInHierarchy(destination)
            ToongetherNavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = destination.icon(),
                        contentDescription = null,
                        tint = if (selected) Color.White else Gray
                    )
                },
                label = {
                    Text(
                        text = destination.label,
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
