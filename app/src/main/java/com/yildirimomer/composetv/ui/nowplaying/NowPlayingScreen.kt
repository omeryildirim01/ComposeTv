package com.yildirimomer.composetv.ui.nowplaying

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.yildirimomer.composetv.ui.common.MovieItem
import com.yildirimomer.composetv.ui.theme.ComposeTvTheme
import com.yildirimomer.domain.entity.NetworkMovie

/**
 * Created by OMER YILDIRIM on 12/26/21.
 */
@Composable
fun NowPlayingScreen() {
    val viewModel = hiltViewModel<NowPlayingViewModel>()

    ComposeTvTheme(darkTheme = true) {
        Column(Modifier.background(Color.DarkGray)) {
            NowPlayingList(movieList = viewModel.nowPlayingList().collectAsLazyPagingItems())
        }
    }
}

@Composable
fun NowPlayingList(movieList: LazyPagingItems<NetworkMovie>) {
    LazyColumn {
        items(movieList.itemCount) { index ->
            movieList[index]?.let {
                MovieItem(movie = it)
            }
        }
    }
}
