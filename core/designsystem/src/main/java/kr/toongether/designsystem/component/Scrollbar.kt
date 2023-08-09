package kr.toongether.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.ScrollIndicator
import kr.toongether.designsystem.theme.TransparentBlack80

@Composable
fun ToongetherScrollbar(
    state: LazyListState,
    modifier: Modifier = Modifier,
) {
    val itemLengthInPx = state.layoutInfo.visibleItemsInfo.firstOrNull()?.size ?: 0
    val lastItemLengthInPx = state.layoutInfo.visibleItemsInfo.lastOrNull()?.size ?: 0

    val length = itemLengthInPx * (state.layoutInfo.totalItemsCount )
    if (length <= 0) return

    val scrolled = state.firstVisibleItemIndex * itemLengthInPx + state.firstVisibleItemScrollOffset
    var yOffset: Float by remember { mutableStateOf(0f) }

    val destiny = LocalDensity.current.density

    Box(
        modifier = modifier
            .wrapContentWidth()
            .fillMaxHeight()
            .background(Color.Green)
            .onGloballyPositioned {

                yOffset = scrolled * (it.size.height / destiny) / length

            }
    ) {

        Box(
            modifier = Modifier
                .offset(0.dp, yOffset.dp)
                .background(TransparentBlack80)
        ) {
            Icon(
                modifier = Modifier.padding(10.dp),
                imageVector = ToongetherIcons.ScrollIndicator,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}