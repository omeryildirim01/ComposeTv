package com.yildirimomer.composetv.ui.popular

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
class PopularViewModel @Inject constructor(
    private val popularRepository: PopularRepository
) : ViewModel() {

    fun getPopularList(): Flow<PagingData<NetworkMovie>> {
        return popularRepository.popular()
    }
}
