package kr.toongether.shortsinterface

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import kr.toongether.designsystem.R
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.theme.GangwonEduPower
import kr.toongether.designsystem.theme.ToongetherColors
import kr.toongether.designsystem.theme.ToongetherTypography
import kr.toongether.designsystem.theme.gangwonedupower
import kr.toongether.model.Shorts
import kr.toongether.ui.shortsCardItems


@ExperimentalMaterial3Api
@Composable
fun ShortsScreen(
    modifier: Modifier = Modifier,
    shortsList: LazyPagingItems<Shorts>,
    onComicClick: (Shorts) -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = ToongetherColors.BackgroundNormal,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Shortoon",
                        fontFamily = GangwonEduPower,
                        style = ToongetherTypography.Title1,
                    )
                },
                actions = {
                    IconButton(onClick = { /*TODO: Navigate To Search*/ }) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = ToongetherIcons.MagnifyingGlass,
                            tint = ToongetherColors.LabelNormal,
                            contentDescription = "Search"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = ToongetherColors.BackgroundNormal,
                ),
                scrollBehavior = scrollBehavior
            )
        }
    ) { paddingValues ->
    }

    Scaffold(
        topBar = {
            ToongetherTopAppBar(
                title = {
                    Text(
                        text = "단편 웹툰",
                        fontFamily = gangwonedupower,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier
                .background(Color.Black)
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            contentPadding = PaddingValues(horizontal = 12.dp)
        ) {
            shortsCardItems(
                items = shortsList,
                onItemClick = onComicClick,
            )
        }
    }
}
