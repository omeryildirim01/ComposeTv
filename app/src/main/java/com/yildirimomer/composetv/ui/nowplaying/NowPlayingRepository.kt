package com.yildirimomer.composetv.ui.nowplaying

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.yildirimomer.domain.entity.NetworkMovie
import com.yildirimomer.domain.usecase.NowPlayingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by OMER YILDIRIM on 12/26/21.
 */
class NowPlayingRepository @Inject constructor(
    private val nowPlayingUseCase: NowPlayingUseCase
) {

    fun nowPlaying(): Flow<PagingData<NetworkMovie>> {
        val config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = true,
            prefetchDistance = 5
        )
        return Pager(config) {
            NowPlayingDataSource(
                nowPlayingUseCase = nowPlayingUseCase
            )
        }.flow
    }
}
