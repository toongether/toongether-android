package kr.toongether.designsystem.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ToongetherTopAppBar(
    title: @Composable () -> Unit,
    actionIcon: ImageVector,
    actionIconContentDescription: String? = null,
    modifier: Modifier = Modifier,
    onActionClick: () -> Unit,
    backgroundColor: Color = Color.Black,
    contentColor: Color = Color.White,
) {
    TopAppBar(
        title = title,
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    imageVector = actionIcon,
                    contentDescription = actionIconContentDescription,
                    modifier = modifier.size(24.dp)
                )
            }
        },
        modifier = modifier,
        backgroundColor = backgroundColor,
        contentColor = contentColor
    )
}

@Composable
fun ToongetherTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Black,
    contentColor: Color = Color.White,
) {
    TopAppBar(
        title = title,
        modifier = modifier,
        backgroundColor = backgroundColor,
        contentColor = contentColor
    )
}

@Composable
fun ToongetherTopAppBar(
    title: @Composable () -> Unit,
    navigationIcon: ImageVector,
    navigationIconContentDescription: String? = null,
    actionIcon: ImageVector,
    actionIconContentDescription: String? = null,
    modifier: Modifier = Modifier,
    onActionClick: () -> Unit,
    onNavigationClick: () -> Unit,
    backgroundColor: Color = Color.Black,
    contentColor: Color = Color.White,
) {
    TopAppBar(
        title = title,
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = navigationIconContentDescription,
                    modifier = modifier.size(24.dp)
                )
            }
        },
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    imageVector = actionIcon,
                    contentDescription = actionIconContentDescription,
                    modifier = modifier.size(24.dp)
                )
            }
        },
        modifier = modifier,
        backgroundColor = backgroundColor,
        contentColor = contentColor
    )
}
