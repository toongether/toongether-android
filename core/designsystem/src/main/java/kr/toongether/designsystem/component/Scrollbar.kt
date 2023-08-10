package kr.toongether.designsystem.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListItemInfo
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import kotlinx.coroutines.launch
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.ScrollIndicator
import kr.toongether.designsystem.theme.TransparentBlack80
import kotlin.math.floor

@Composable
fun ToongetherScrollbar(
    modifier: Modifier = Modifier,
    listState: LazyListState,
    thumbMinHeight: Float = 0.1f,
    isShow: Boolean,
    content: @Composable () -> Unit
) {
    Box {
        content()
        InternalToongetherScrollbar(
            modifier = modifier,
            listState = listState,
            thumbMinHeight = thumbMinHeight,
            isShow = isShow
        )
    }
}

@Composable
internal fun InternalToongetherScrollbar(
    listState: LazyListState,
    modifier: Modifier = Modifier,
    thumbMinHeight: Float = 0.1f,
    isShow: Boolean
) {
    val coroutineScope = rememberCoroutineScope()

    var isSelected by remember { mutableStateOf(false) }

    var dragOffset by remember { mutableStateOf(0f) }

    val reverseLayout by remember { derivedStateOf { listState.layoutInfo.reverseLayout } }

    val realFirstVisibleItem by remember {
        derivedStateOf {
            listState.layoutInfo.visibleItemsInfo.firstOrNull {
                it.index == listState.firstVisibleItemIndex
            }
        }
    }

    val isStickyHeaderInAction by remember {
        derivedStateOf {
            val realIndex = realFirstVisibleItem?.index ?: return@derivedStateOf false
            val firstVisibleIndex = listState.layoutInfo.visibleItemsInfo.firstOrNull()?.index
                ?: return@derivedStateOf false
            realIndex != firstVisibleIndex
        }
    }

    fun LazyListItemInfo.fractionHiddenTop(firstItemOffset: Int) =
        if (size == 0) 0f else firstItemOffset / size.toFloat()

    fun LazyListItemInfo.fractionVisibleBottom(viewportEndOffset: Int) =
        if (size == 0) 0f else (viewportEndOffset - offset).toFloat() / size.toFloat()

    val normalizedThumbSizeReal by remember {
        derivedStateOf {
            listState.layoutInfo.let {
                if (it.totalItemsCount == 0) {
                    return@let 0f
                }

                val firstItem = realFirstVisibleItem ?: return@let 0f
                val firstPartial =
                    firstItem.fractionHiddenTop(listState.firstVisibleItemScrollOffset)
                val lastPartial =
                    1f - it.visibleItemsInfo.last().fractionVisibleBottom(it.viewportEndOffset)

                val realSize = it.visibleItemsInfo.size - if (isStickyHeaderInAction) 1 else 0
                val realVisibleSize = realSize.toFloat() - firstPartial - lastPartial
                realVisibleSize / it.totalItemsCount.toFloat()
            }
        }
    }

    val normalizedThumbSize by remember {
        derivedStateOf {
            normalizedThumbSizeReal.coerceAtLeast(thumbMinHeight)
        }
    }

    fun offsetCorrection(top: Float): Float {
        val topRealMax = (1f - normalizedThumbSizeReal).coerceIn(0f, 1f)
        if (normalizedThumbSizeReal >= thumbMinHeight) {
            return top
        }

        val topMax = 1f - thumbMinHeight
        return top * topMax / topRealMax
    }

    fun offsetCorrectionInverse(top: Float): Float {
        if (normalizedThumbSizeReal >= thumbMinHeight) {
            return top
        }
        val topRealMax = 1f - normalizedThumbSizeReal
        val topMax = 1f - thumbMinHeight
        return top * topRealMax / topMax
    }

    val normalizedOffsetPosition by remember {
        derivedStateOf {
            listState.layoutInfo.let {
                if (it.totalItemsCount == 0 || it.visibleItemsInfo.isEmpty()) {
                    return@let 0f
                }

                val firstItem = realFirstVisibleItem ?: return@let 0f
                val top = firstItem.run {
                        index.toFloat() + fractionHiddenTop(listState.firstVisibleItemScrollOffset)
                    } / it.totalItemsCount.toFloat()
                offsetCorrection(top)
            }
        }
    }

    fun setDragOffset(value: Float) {
        val maxValue = (1f - normalizedThumbSize).coerceAtLeast(0f)
        dragOffset = value.coerceIn(0f, maxValue)
    }

    fun setScrollOffset(newOffset: Float) {
        setDragOffset(newOffset)
        val totalItemsCount = listState.layoutInfo.totalItemsCount.toFloat()
        val exactIndex = offsetCorrectionInverse(totalItemsCount * dragOffset)
        val index: Int = floor(exactIndex).toInt()
        val remainder: Float = exactIndex - floor(exactIndex)

        coroutineScope.launch {
            listState.scrollToItem(index = index, scrollOffset = 0)
            val offset = realFirstVisibleItem
                ?.size
                ?.let { it.toFloat() * remainder }
                ?.toInt() ?: 0
            listState.scrollToItem(index = index, scrollOffset = offset)
        }
    }

    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
    ) {
        val maxHeightFloat = constraints.maxHeight.toFloat()
        ConstraintLayout(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .graphicsLayer(
                    translationY = maxHeightFloat * normalizedOffsetPosition
                )
        ) {
            val (box) = createRefs()

            AnimatedVisibility(
                visible = isShow || isSelected,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Box(
                    modifier = Modifier
                        .background(TransparentBlack80)
                        .constrainAs(box) {
                            end.linkTo(parent.end)
                        }
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

        @Composable
        fun DraggableBar() = Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .width(30.dp)
                .fillMaxHeight()
                .draggable(
                    state = rememberDraggableState { delta ->
                        val displace = if (reverseLayout) -delta else delta
                        if (isSelected) {
                            setScrollOffset(dragOffset + displace / maxHeightFloat)
                        }
                    },
                    orientation = Orientation.Vertical,
                    startDragImmediately = true,
                    onDragStarted = onDragStarted@{ offset ->
                        if (maxHeightFloat <= 0f) return@onDragStarted
                        val newOffset = when {
                            reverseLayout -> (maxHeightFloat - offset.y) / maxHeightFloat
                            else -> offset.y / maxHeightFloat
                        }
                        val currentOffset = when {
                            reverseLayout -> 1f - normalizedOffsetPosition - normalizedThumbSize
                            else -> normalizedOffsetPosition
                        }

                        if (newOffset in currentOffset..(currentOffset + normalizedThumbSize)) {
                            setDragOffset(currentOffset)
                            isSelected = true
                        }
                    },
                    onDragStopped = {
                        isSelected = false
                    }
                )
        )
        DraggableBar()
    }
}
