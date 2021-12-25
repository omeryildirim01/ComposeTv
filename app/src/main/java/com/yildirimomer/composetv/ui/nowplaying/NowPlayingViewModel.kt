package com.yildirimomer.composetv.ui.nowplaying

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.yildirimomer.domain.entity.NetworkMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by OMER YILDIRIM on 12/26/21.
 */
@HiltViewModel
class NowPlayingViewModel @Inject constructor(
    private val nowPlayingRepository: NowPlayingRepository
) : ViewModel() {

    fun nowPlayingList(): Flow<PagingData<NetworkMovie>> {
        return nowPlayingRepository.nowPlaying()
    }
}
