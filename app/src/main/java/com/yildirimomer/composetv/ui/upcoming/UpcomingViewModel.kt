package com.yildirimomer.composetv.ui.upcoming

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
class UpcomingViewModel @Inject constructor(
    private val upcomingRepository: UpcomingRepository
) : ViewModel() {

    fun upcomingList(): Flow<PagingData<NetworkMovie>> {
        return upcomingRepository.upcoming()
    }
}
