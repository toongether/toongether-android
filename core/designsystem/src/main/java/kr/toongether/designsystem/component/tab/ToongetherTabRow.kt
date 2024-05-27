package kr.toongether.designsystem.component.tab

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastFold
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastMap
import kr.toongether.designsystem.theme.ToongetherColors

@Composable
fun ToongetherTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = ToongetherColors.BackgroundNormal,
    indicatorColor: Color = ToongetherColors.LabelNormal,
    contentSpaceBy: Dp = 16.dp,
    tabs: @Composable () -> Unit
) {
    var indicatorWidth by remember { mutableStateOf(0.dp) }
    var indicatorOffset by remember { mutableIntStateOf(0) }

    val animatedIndicatorWidth by animateDpAsState(
        targetValue = indicatorWidth,
        label = "indicatorWidthAnimation"
    )
    val animatedIndicatorOffset by animateIntAsState(
        targetValue = indicatorOffset,
        label = "indicatorOffsetAnimation"
    )

    Column(
        modifier = modifier
            .selectableGroup()
            .background(containerColor)
            .padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        SubcomposeLayout { constraints ->
            val tabPlaceables = subcompose("tabs", tabs).fastMap {
                it.measure(constraints)
            }

            val tabRowHeight = tabPlaceables.fastFold(0) { max, placeable ->
                maxOf(max, placeable.height)
            }

            val totalTabWidth =
                tabPlaceables.sumOf { it.width } + (tabPlaceables.size - 1) * contentSpaceBy.toPx()
            val availableWidth = constraints.maxWidth
            val startX = ((availableWidth - totalTabWidth) / 2).toInt()

            val selectedTabWidth = tabPlaceables.getOrNull(selectedTabIndex)?.width?.toDp() ?: 0.dp
            val selectedTabOffset = startX + tabPlaceables.take(selectedTabIndex)
                .sumOf { it.width + contentSpaceBy.toPx().toInt() }


            indicatorWidth = selectedTabWidth
            indicatorOffset = selectedTabOffset

            layout(availableWidth, tabRowHeight) {
                var xPosition = startX

                tabPlaceables.fastForEach { placeable ->
                    placeable.place(x = xPosition, y = 0)
                    xPosition += placeable.width + contentSpaceBy.toPx().toInt()
                }
            }
        }
        Box(
            modifier = Modifier
                .size(animatedIndicatorWidth, 2.dp)
                .offset { IntOffset(animatedIndicatorOffset, 0) }
                .background(indicatorColor, CircleShape)
        )
    }
}

@Composable
@Preview
private fun ToongetherTabRowPreview() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    ToongetherTabRow(
        selectedTabIndex = selectedTabIndex,
        tabs = {
            ToongetherTab(
                selected = selectedTabIndex == 0,
                onClick = { selectedTabIndex = 0 },
                content = {
                    Text(text = "Tab 1")
                }
            )
            ToongetherTab(
                selected = selectedTabIndex == 1,
                onClick = { selectedTabIndex = 1 },
                content = {
                    Text(text = "Tab 2")
                }
            )

            ToongetherTab(
                selected = selectedTabIndex == 2,
                onClick = { selectedTabIndex = 2 },
                content = {
                    Text(text = "Tab 3")
                }
            )
        }
    )
}
